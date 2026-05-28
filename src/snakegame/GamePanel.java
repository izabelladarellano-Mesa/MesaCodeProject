/**
* Lead Author(s):
* @author izabellaarellano; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
*
*Code snake game in Java. (2023, July 19). YouTube. https://youtu.be/Y62MJny9LHg?si=hgmfGnfVQsrohxyY
* <<Add more references here>>
*
* Version: 2026-05-19
*/
package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * GamePanel class
 * -----------------------------------
 * Responsibility:
 * - Displays board
 * - Runs game loop using Timer
 * - Handles keyboard input
 * - Draws snake and food
 * - Detects collisions
 * - Tracks score
 * - Saves and loads high scores
 * - Handles restart features
 *
 * Relationships:
 * - Stores many CellButtons in a 2D array
 * - Uses Snake to manage snake movement
 * - Uses Food to track food location
 * - Uses HighScoreManager to save/load scores
 *
 * Learning Outcomes:
 * - LO2: 2D arrays
 * - LO5: Collision handling
 * - LO6: File IO
 * - LO7: GUI and events
 * - LO8: Data structures
 */
//GamePanel is-a JPanel
public class GamePanel extends JPanel {

	// Defines number of rows in the game board grid
	private final int ROWS = 10;

	// Defines number of columns in the game board grid
	private final int COLS = 10;

    // GamePanel has-many CellButtons stored in a 2D array
    private CellButton[][] grid;

    // GamePanel uses Snake to manage snake state
    private Snake snake;

    // GamePanel uses Food to track food location
    private Food food;

    // GamePanel has-a Timer used for repeated updates
    private Timer timer;

    // GamePanel uses HighScoreManager
    // to save and load high scores
    private HighScoreManager scoreManager;

    // Stores current score earned during gameplay
    private int score;

    // Stores highest saved score
    private int highScore;

    /**
     * Constructor
     *
     * Initializes board, snake,
     * food, controls, and timer
     */
    public GamePanel() {

        try {

            grid = new CellButton[ROWS][COLS];

            setLayout(new GridLayout(ROWS, COLS));

            initializeGrid();

            startNewGame();
            
            setupKeyControls();

            timer = new Timer(300, e -> updateGame());

            timer.start();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error initializing game:\n"
                    + e.getMessage(),
                    "Initialization Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }

  /**
   * Starts or restarts game
   * 
   *  @return void
   */
    private void startNewGame() {
    	snake = new Snake (5, 5);
    	
    	food = new Food();
    	
    	scoreManager = new HighScoreManager();
    	
    	highScore = scoreManager.loadHighScore();
    	
    	food.spawn(ROWS, COLS, snake.getBody());
    	
    	score = 0;
    	
    	clearBoard();
    	
    	drawFood();
    	
    	drawSnake();
    	
    } 
    
    /**
     * Builds board grid
     *
     * @return void
     */
    private void initializeGrid() {

        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {

                grid[r][c] = new CellButton();

                add(grid[r][c]);
            }
        }
    }

    /**
     * Handles keyboard input
     *
     * @return void
     */
    private void setupKeyControls() {

        addKeyListener(new KeyAdapter() {

            /**
             * Detects key press
             *
             * @param e keyboard event
             * @return void
             */
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if (key == KeyEvent.VK_UP) {

                    snake.setDirection(0, -1);

                } else if (key == KeyEvent.VK_DOWN) {

                    snake.setDirection(0, 1);

                } else if (key == KeyEvent.VK_LEFT) {

                    snake.setDirection(-1, 0);

                } else if (key == KeyEvent.VK_RIGHT) {

                    snake.setDirection(1, 0);
                }
            }
        });

        setFocusable(true);

        requestFocus();
    }

    /**
     * Updates game each timer step
     *
     * @return void
     */
    private void updateGame() {

        try {

            snake.move();

            if (checkWallCollision()
                    || checkSelfCollision()) {

                endGame();

                return;
            }

            checkFoodCollision();

            clearBoard();

            drawFood();

            drawSnake();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error during game update:\n"
                    + e.getMessage(),
                    "Game Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();

            timer.stop();
        }
    }

    /**
     * Detects wall collision
     *
     * @return true if collision occurs
     */
    private boolean checkWallCollision() {

        Point head = snake.getHead();

        return head.x < 0
                || head.x >= COLS
                || head.y < 0
                || head.y >= ROWS;
    }

    /**
     * Detects collision with snake body
     *
     * @return true if snake hits itself
     */
    private boolean checkSelfCollision() {

        Point head = snake.getHead();

        for (int i = 1;
             i < snake.getBody().size();
             i++) {

            if (head.equals(
                    snake.getBody().get(i))) {

                return true;
            }
        }

        return false;
    }

    /**
     * Checks if snake ate food
     *
     * @return void
     */
    private void checkFoodCollision() {

        if (snake.getHead().equals(
                food.getPosition())) {

            snake.grow();

            score++;

            food.spawn(
                    ROWS,
                    COLS,
                    snake.getBody()
            );
        }
    }

    /**
     * Ends game
     *
     * @return void
     */
    private void endGame() {

        timer.stop();

        // Save new high score
        if (score > highScore) {

            highScore = score;

            scoreManager.saveHighScore(
                    highScore
            );
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Game Over!"
                + "\nScore: " + score
                + "\nHigh Score: " + highScore
                + "\n\nRestart Game?",
                "Snake Game",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            startNewGame();

            timer.start();
        } else {
        	System.exit(0);
        }
    }

    /**
     * Draws snake
     *
     * @return void
     */
    private void drawSnake() {

        for (Point p : snake.getBody()) {

            setCellColor(
                    p.y,
                    p.x,
                    Color.GREEN
            );
        }

        // Draw snake head differently
        Point head = snake.getHead();

        setCellColor(
                head.y,
                head.x,
                Color.YELLOW
        );
    }

    /**
     * Draws food
     *
     * @return void
     */
    private void drawFood() {

        Point p = food.getPosition();

        setCellColor(
                p.y,
                p.x,
                Color.RED
        );
    }

    /**
     * Sets one cell color
     *
     * @param row row index
     * @param col column index
     * @param color desired color
     * @return void
     */
    public void setCellColor(
            int row,
            int col,
            Color color) {

        grid[row][col]
                .setCellColor(color);
    }

    /**
     * Clears board
     *
     * @return void
     */
    public void clearBoard() {

        for (int r = 0; r < ROWS; r++) {

            for (int c = 0;
                 c < COLS;
                 c++) {

                grid[r][c].clearCell();
            }
        }
    }
}
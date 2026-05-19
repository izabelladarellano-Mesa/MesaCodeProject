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
 *
 * - Relationships:
 * - Stores many CellButtons in a 2D array
 * - Uses Snake to manage snake movement
 * - Uses Food to track food location
 *
 * Sources:
 * - Oracle Swing Timer Tutorial
 *   https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html
 *   Video- used as referance
 *   It mentioned a timer and decided to use one and used the Oracle Tutorial as help
 *   Code snake game in Java. (2023, July 19). YouTube. https://youtu.be/Y62MJny9LHg?si=hgmfGnfVQsrohxyY
 *
 * Used for repeated game updates.
 *
 * Learning Outcomes:
 * - LO2: 2D arrays
 * - LO5: Collision handling
 * - LO7: GUI
 * - LO8: Data structures
 */
public class GamePanel extends JPanel {

    private final int ROWS = 10;
    private final int COLS = 10;

    // GamePanel has-many CellButtons stored in a 2D array
    private CellButton[][] grid;

    // GamePanel uses Snake to manage snake state
    private Snake snake;

    // GamePanel uses Food to track food location
    private Food food;

    // A GamePanel has-a Timer used to control the game loop and timed events
    private Timer timer;
    
    //Tracks player score
    private int score;

    /**
     * Constructor
     * 
     * Initializes board, snake, food, controls, and timer
     */
    public GamePanel() {

        grid = new CellButton[ROWS][COLS];

        setLayout(new GridLayout(ROWS, COLS));

        initializeGrid();

        snake = new Snake(5, 5);

        food = new Food();
       //prevents food from spawning inside snake
        food.spawn(ROWS, COLS, snake.getBody());
        
        score = 0;
        
        setupKeyControls();
        
        drawFood();
        
        drawSnake();

        // Calls updateGame repeatedly
        timer = new Timer(300, e -> updateGame());
        timer.start();
    }

    /**
     * Builds board
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
     * handles keyboard input
     * 
     * @return void
     */
    private void setupKeyControls() {

        addKeyListener(new KeyAdapter() {

            /**
             * Detects key press
             *
             * @param e KeyEvent
             * @return void
             */
            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if (key == KeyEvent.VK_UP) {
                    snake.setDirection(0, -1);
                }
                else if (key == KeyEvent.VK_DOWN) {
                    snake.setDirection(0, 1);
                }
                else if (key == KeyEvent.VK_LEFT) {
                    snake.setDirection(-1, 0);
                }
                else if (key == KeyEvent.VK_RIGHT) {
                    snake.setDirection(1, 0);
                }
            }
        });

        setFocusable(true);
        requestFocus();
    }

    /**
     * Runs each timer step
     *
     * @return void
     */
    private void updateGame() {

        snake.move();

        // End game if collision occurs
        if (checkWallCollision() || checkSelfCollision()) {

            endGame();

            return;
        }

        checkFoodCollision();

        clearBoard();

        drawFood();

        drawSnake();
    }

    /**
     * Detects wall collision
     *
     * @return true if collision occurs
     */
    private boolean checkWallCollision() {

        Point head = snake.getHead();

        return head.x < 0 ||
               head.x >= COLS ||
               head.y < 0 ||
               head.y >= ROWS;
    }
    
    /**
     * Detects collision with snake body
     *
     * @return true if snake hits itself
     */
    private boolean checkSelfCollision() {

        Point head = snake.getHead();

        for (int i = 1; i < snake.getBody().size(); i++) {

            if (head.equals(snake.getBody().get(i))) {

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

        if (snake.getHead().equals(food.getPosition())) {

            snake.grow();

            score++;

            // Prevents food from spawning inside snake
            food.spawn(ROWS, COLS, snake.getBody());
        }
    }
    
    /**
     * Ends game
     *
     * @return void
     */
    private void endGame() {

        timer.stop();

        JOptionPane.showMessageDialog(
                this,
                "Game Over!\nScore: " + score
        );
    }


    /**
     * Draws snake
     *
     * @return void
     */
    private void drawSnake() {

        for (Point p : snake.getBody()) {

            setCellColor(p.y, p.x, Color.GREEN);
        }
        
        //draw snake head differently
        Point head = snake.getHead();
        
        setCellColor(head.y, head.x, Color.YELLOW);
    }
   

    /**
     * Draws food
     *
     * @return void
     */
    private void drawFood() {

        Point p = food.getPosition();

        setCellColor(p.y, p.x, Color.RED);
    }

    /**
     * Sets one cell color
     *
     * @param row row index
     * @param col column index
     * @param color desired color
     * @return void
     */
    public void setCellColor(int row, int col, Color color) {

        grid[row][col].setCellColor(color);
    }

    /**
     * Clears board
     *
     * @return void
     */
    public void clearBoard() {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                grid[r][c].clearCell();
            }
        }
    }
}
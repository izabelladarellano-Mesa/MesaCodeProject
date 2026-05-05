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
* Version: 2026-05-01
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
 *
 * Relationships:
 * - Has-a CellButton[][]
 * - Has-a Snake
 * - Has-a Food
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
 * - LO7: GUI
 */
public class GamePanel extends JPanel {

    private final int ROWS = 10;
    private final int COLS = 10;

    private CellButton[][] grid;

    private Snake snake;
    private Food food;

    private Timer timer;

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
        food.spawn(ROWS, COLS);
        
        setupKeyControls();

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

        Point head = snake.getHead();

        //stop game if snake hits wall
        if (head.x < 0 || head.x >= COLS ||
            head.y < 0 || head.y >= ROWS) {

            timer.stop();
            return;
        }

        checkFoodCollision();

        clearBoard();

        drawFood();

        drawSnake();
    }

    /**
     * Checks if snake ate food
     *
     * @return void
     */
    private void checkFoodCollision() {

        if (snake.getHead().equals(food.getPosition())) {

            snake.grow();

            food.spawn(ROWS, COLS);
        }
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
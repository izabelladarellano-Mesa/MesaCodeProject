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
* <<Add more references here>>
*
* Version: 2026-04-22
*/
package snakegame;

import javax.swing.*;
import java.awt.*;

/**
 * GamePanel class
 * -----------------------------------
 * Responsibility:
 * - Displays board
 * - Draws snake and food
 * - Detects food collision
 *
 * Relationships:
 * - Has-a CellButton[][]
 * - Has-a Snake
 * - Has-a Food
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
     * Creates board, snake, food, timer
     */
    public GamePanel() {

        grid = new CellButton[ROWS][COLS];

        setLayout(new GridLayout(ROWS, COLS));

        initializeGrid();

        snake = new Snake(5, 5);

        food = new Food();
        food.spawn(ROWS, COLS);

        timer = new Timer(300, e -> updateGame());
        timer.start();
    }

    /**
     * Builds grid
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
     * Updates game every timer tick
     *
     * @return void
     */
    private void updateGame() {

        snake.move();

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
     * Sets cell color
     *
     * @param row row location
     * @param col column location
     * @param color color to use
     * @return void
     */
    public void setCellColor(int row, int col, Color color) {
        grid[row][col].setBackground(color);
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
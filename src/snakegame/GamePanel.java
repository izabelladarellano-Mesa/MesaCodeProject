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
* Version: 2026-04-06
*/
package snakegame;

import javax.swing.*;
import java.awt.*;

/**
 * GamePanel class
 * -----------------------------------
 * Responsibility:
 * - Represents the game board (View in MVC)
 * - Displays a grid using JButtons
 * - Provides methods to update and clear the board
 *
 * Relationships:
 * - Used by Game (Game has-a GamePanel)
 * - Will later collaborate with Snake, Food, GameController
 *
 * Learning Outcomes:
 * - LO2: Uses 2D arrays (JButton[][])
 * - LO7: GUI with Swing (JPanel, GridLayout)
 */
public class GamePanel extends JPanel {

    // Constants defining board size
    private final int ROWS = 10;
    private final int COLS = 10;

    // 2D array representing the grid (GameBoard)
    private JButton[][] grid;

    /**
     * Constructor for GamePanel
     *
     * Initializes the grid and layout
     *
     * @param none
     * @return none
     */
    public GamePanel() {

        // Initialize grid array
        grid = new JButton[ROWS][COLS];

        // Set layout manager
        setLayout(new GridLayout(ROWS, COLS));

        // Build the grid
        initializeGrid();
    }

    /**
     * Initializes the grid of buttons
     *
     * Each JButton represents one cell on the board
     *
     * @param none
     * @return void
     */
    private void initializeGrid() {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

            	grid[r][c] = new JButton();

            	// Mac compatibility
            	grid[r][c].setOpaque(true);
            	grid[r][c].setContentAreaFilled(true);

            	// ❌ DO NOT turn off borders completely
            	// grid[r][c].setBorderPainted(false);  ← remove or comment this out

            	// Add grid lines
            	grid[r][c].setBorder(BorderFactory.createLineBorder(Color.GRAY));

            	// Default background
            	grid[r][c].setBackground(Color.BLACK);

            	grid[r][c].setFocusable(false);

                // Add to panel
                add(grid[r][c]);
            }
        }
    }

    /**
     * Sets the color of a specific cell
     *
     * Used for:
     * - Snake (green)
     * - Food (red)
     * - Empty space (black)
     *
     * @param row the row index
     * @param col the column index
     * @param color the color to apply
     * @return void
     */
    public void setCellColor(int row, int col, Color color) {
        grid[row][col].setBackground(color);
    }

    /**
     * Clears the board (resets all cells to black)
     *
     * @param none
     * @return void
     */
    public void clearBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c].setBackground(Color.BLACK);
            }
        }
    }

    /**
     * Draws a test pattern on the board
     *
     * This verifies that:
     * - The grid is working
     * - Colors display correctly
     *
     * @param none
     * @return void
     */
    public void drawTestPattern() {

        // Clear board first
        clearBoard();

        // Simulated snake (green)
        setCellColor(5, 5, Color.GREEN);
        setCellColor(5, 6, Color.GREEN);
        setCellColor(5, 7, Color.GREEN);

        // Simulated food (red)
        setCellColor(3, 3, Color.RED);

        // Force repaint (ensures update on Mac)
        repaint();
    }
    /**
     * Gets number of rows
     *
     * @param none
     * @return int number of rows
     */
    public int getRows() {
        return ROWS;
    }

    /**
     * Gets number of columns
     *
     * @param none
     * @return int number of columns
     */
    public int getCols() {
        return COLS;
    }
    /**
     * Draws the snake on the board
     *
     * @param snake the Snake object
     * @return void
     */
    public void drawSnake(Snake snake) {
        snake.draw(this);
    }
    
}
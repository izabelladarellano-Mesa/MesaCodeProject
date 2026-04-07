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
 *
 * Relationships:
 * - Used by Game (Game has-a GamePanel)
 * - Will later interact with Snake, Food, and GameController
 *
 * Learning Outcomes:
 * - LO2: Uses 2D arrays (JButton[][])
 * - LO7: GUI with Swing (JPanel, GridLayout)
 */
public class GamePanel extends JPanel {

    // Constants for grid size
    private final int ROWS = 10;
    private final int COLS = 10;

    // 2D array of buttons representing the grid
    private JButton[][] grid;

    /**
     * Constructor for GamePanel
     *
     * Initializes the grid and sets up the layout
     *
     * @param none
     * @return none
     */
    public GamePanel() {

        // Initialize the 2D array
        grid = new JButton[ROWS][COLS];

        // Set layout manager (GridLayout)
        setLayout(new GridLayout(ROWS, COLS));

        // Create and add buttons to the panel
        initializeGrid();
    }

    /**
     * Initializes the grid of JButtons
     *
     * Each button represents one cell on the board
     *
     * @param none
     * @return void
     */
    private void initializeGrid() {

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                // Create a new button
                grid[r][c] = new JButton();

                // Set default appearance
                grid[r][c].setBackground(Color.BLACK);
                grid[r][c].setFocusable(false); // Prevents button focus highlight

                // Optional: Add grid lines for better visibility
                grid[r][c].setBorder(BorderFactory.createLineBorder(Color.GRAY));

                // Add button to panel
                add(grid[r][c]);
            }
        }
    }

    /**
     * Gets a button at a specific row and column
     *
     * @param row the row index
     * @param col the column index
     * @return JButton at the specified position
     */
    public JButton getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Gets number of rows in the grid
     *
     * @param none
     * @return int number of rows
     */
    public int getRows() {
        return ROWS;
    }

    /**
     * Gets number of columns in the grid
     *
     * @param none
     * @return int number of columns
     */
    public int getCols() {
        return COLS;
    }
}
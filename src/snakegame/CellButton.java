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
 * CellButton class
 * -----------------------------------
 * Responsibility:
 * - Represents a single cell in the game board
 * - Encapsulates all button styling and behavior
 *
 * Relationships:
 * - Used by GamePanel (GamePanel has-a CellButton[][])
 *
 * Source:
 * - Based on Java Swing behavior where JButton appearance depends on Look & Feel.
 * - According to Oracle Swing documentation, properties like setOpaque(true)
 *   and setContentAreaFilled(true) may be required for background colors to display.
 *   // Source: Oracle Java Swing Tutorial - JButton
// https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 *
 * Learning Outcomes:
 * - LO1: Object-Oriented Design (encapsulation)
 * - LO3: Objects and classes
 */
public class CellButton extends JButton {
	
    /**
     * Constructor for CellButton
     *
     * Initializes appearance and default state
     *
     * @param none
     * @return none
     */
    public CellButton() {

        // Ensure background color is visible (especially on macOS)
        setOpaque(true);
        setContentAreaFilled(true);

        // Add grid border
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Default cell color (empty)
        setBackground(Color.BLACK);

        // Prevent focus highlight
        setFocusable(false);
    }

    /**
     * Clears the cell (resets to empty state)
     *
     * @param none
     * @return void
     */
    public void clearCell() {
        setBackground(Color.BLACK);
    }
}
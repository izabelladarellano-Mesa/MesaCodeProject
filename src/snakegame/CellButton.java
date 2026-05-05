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
*Code snake game in Java. (2023, July 19). YouTube. https://youtu.be/Y62MJny9LHg?si=hgmfGnfVQsrohxyY
* <<Add more references here>>
*
* Version: 2026-05-01
*/
package snakegame;

import javax.swing.*;
import java.awt.*;

/**
 * CellButton class
 * -----------------------------------
 * Responsibility:
 * - Represents one cell on the board
 * - Encapsulates button styling
 *
 * Relationships:
 * - GamePanel has-a CellButton[][]
 *
 * Sources:
 * - Oracle Swing Tutorial: JButton
 *   https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 *   Used for JButton appearance properties.
 *-JButton will not display background color. (2015, April 21). Stack Overflow. https://stackoverflow.com/questions/29781275/jbutton-will-not-display-background-color
 * Notes:
 * - setOpaque(true) and setContentAreaFilled(true)
 *   were used as help from a source that showed a similar issue of color not showing up
 *
 * Learning Outcomes:
 * - LO1: Encapsulation
 * - LO3: Classes and objects
 */
public class CellButton extends JButton {

    /**
     * Constructor
     *
     * Initializes button appearance
     */
    public CellButton() {

        // Helps background colors render correctly
    	//found it as Mac Compatibility - Stack Overflow website
        setOpaque(true);
        setContentAreaFilled(true);

        // Add border around each cell
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Default empty color
        setBackground(Color.BLACK);

        // Remove focus outline
        setFocusable(false);
    }

    /**
     * Clears cell color
     *
     * @return void
     */
    public void clearCell() {
        setBackground(Color.BLACK);
    }

    /**
     * Sets cell color
     *
     * @param color new color
     * @return void
     */
    public void setCellColor(Color color) {
        setBackground(color);
    }
}
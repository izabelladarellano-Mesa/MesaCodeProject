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

import javax.swing.JFrame;

/**
 * Game class
 * -----------------------------------
 * Responsibility:
 * - Entry point of the program
 * - Creates and displays the main window (JFrame)
 *
 * Relationships:
 * - Has-a GamePanel (composition relationship)
 */
public class Game {

    /**
     * Main method - starts the program
     *
     * @param args command-line arguments (not used)
     * @return void
     */
    public static void main(String[] args) {

        // Create main window
        JFrame frame = new JFrame("Snake Game");

        // Create GamePanel (View)
        GamePanel panel = new GamePanel();

        // Add panel to frame
        frame.add(panel);

        // Frame settings
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Make visible BEFORE drawing (important)
        frame.setVisible(true);

        // Draw test pattern so colors appear
        panel.drawTestPattern();
    }
}
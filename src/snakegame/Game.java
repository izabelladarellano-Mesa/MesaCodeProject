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
 * - Creates and displays the main game window (JFrame)
 *
 * Relationships:
 * - Uses (has-a) GamePanel
 */
public class Game {

    /**
     * Main method - starts the program
     *
     * @param args command-line arguments (not used)
     * @return void
     */
    public static void main(String[] args) {

        // Create the main window (JFrame)
        JFrame frame = new JFrame("Snake Game");

        // Create the game panel (View)
        GamePanel panel = new GamePanel();

        // Add panel to frame
        frame.add(panel);

        // Set frame properties
        frame.setSize(500, 500); // Window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on exit
        frame.setResizable(false); // Prevent resizing

        // Make window visible
        frame.setVisible(true);
    }
}
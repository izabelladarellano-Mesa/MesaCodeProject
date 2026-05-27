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
* Code snake game in Java. (2023, July 19). YouTube. https://youtu.be/Y62MJny9LHg?si=hgmfGnfVQsrohxyY
* <<Add more references here>>
*
* Version: 2026-05-19
*/
package snakegame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Game class
 * -----------------------------------
 * Responsibility:
 * - Starts Snake Game program
 * - Creates application window
 * - Handles startup exceptions
 *
 * Relationships:
 * - Uses GamePanel to display the game
 *
 * Learning Outcomes:
 * - LO3: Classes and objects
 * - LO5: Exception handling
 * - LO7: GUI setup
 */
public class Game {

    /**
     * Main method
     *
     * @param args command line arguments
     * @return none
     */
    public static void main(String[] args) {

        try {

            JFrame frame = new JFrame("Snake Game");

            // Game uses GamePanel to display the game
            GamePanel panel = new GamePanel();

            frame.add(panel);

            frame.setSize(500, 500);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setResizable(false);

            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

            panel.requestFocus();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "An unexpected error occurred:\n"
                    + e.getMessage(),
                    "Program Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}
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
 * - Starts the program
 * - Creates window and runs basic snake test
 *
 * Relationships:
 * - Has-a GamePanel
 * - Uses Snake
 */
public class Game {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake Game");

        GamePanel panel = new GamePanel();

        frame.add(panel);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        // Create snake in middle
        Snake snake = new Snake(5, 5);

        // Draw snake
        panel.clearBoard();
        panel.drawSnake(snake);
    }
}
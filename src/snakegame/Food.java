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
* Version: 2026-04-27
*/
package snakegame;

import java.awt.Point;
import java.util.Random;

/**
 * Food class
 * -----------------------------------
 * Responsibility:
 * - Represents food on the board
 * - Spawns in random locations
 *
 * Relationships:
 * - Used by GamePanel
 * - Uses Point to store position
 *
 * Learning Outcomes:
 * - LO3: Classes and objects
 * - LO2: Arrays (board positions)
 */
public class Food {

    // Food location
    private Point position;

    // Random number generator
    private Random rand;

    /**
     * Constructor
     *
     * Creates Food object and random generator
     */
    public Food() {
        rand = new Random();
        position = new Point(0, 0);
    }

    /**
     * Spawns food at random location
     *
     * @param rows total rows
     * @param cols total columns
     * @return void
     */
    public void spawn(int rows, int cols) {

        int x = rand.nextInt(cols);
        int y = rand.nextInt(rows);

        position = new Point(x, y);
    }

    /**
     * Returns food position
     *
     * @return Point food location
     */
    public Point getPosition() {
        return position;
    }
}
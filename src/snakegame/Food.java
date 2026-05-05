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
*Used as a reference and help if needed
* <<Add more references here>>
*
* Version: 2026-05-01
*/
package snakegame;

import java.awt.Point;
import java.util.Random;

/**
 * Food class
 * -----------------------------------
 * Responsibility:
 * - Represents food item
 * - Spawns randomly on board
 *
 * Relationships:
 * - GamePanel uses Food
 *
 * Sources:
 * - Java API Documentation: java.util.Random
 *   Used for random spawn locations.
 *
 * Learning Outcomes:
 * - LO3: Classes and objects
 */
public class Food {

    private Point position;

    private Random rand;

    /**
     * Constructor
     */
    public Food() {

        rand = new Random();

        position = new Point(0, 0);
    }

    /**
     * Spawns food randomly
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
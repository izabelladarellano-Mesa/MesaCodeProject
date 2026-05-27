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
* Version: 2026-05-19
*/
package snakegame;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

/**
 * Food class
 * -----------------------------------
 * Responsibility:
 * - Represents food item
 * - Spawns randomly on board
 *
 * Relationships:
 * - Used by GamePanel to track food position
 * - Uses Random to generate spawn locations
 * - Has-a Point representing food location
 *
 * Learning Outcomes:
 * - LO3: Classes and objects
 * - LO5: Edge case handling
 */
public class Food {

    // Food has-a Point representing location
    private Point position;

    // Food uses Random for spawn locations
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
     * Prevents spawning inside snake
     *
     * @param rows total rows
     * @param cols total columns
     * @param snakeBody snake body positions
     * @return void
     */
    public void spawn(int rows,
                      int cols,
                      LinkedList<Point> snakeBody) {

        try {

            do {

                int x = rand.nextInt(cols);

                int y = rand.nextInt(rows);

                position = new Point(x, y);

            } while (snakeBody.contains(position));

        } catch (Exception e) {

            System.out.println(
                    "Error spawning food."
            );

            e.printStackTrace();
        }
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
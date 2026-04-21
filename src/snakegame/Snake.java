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
* Version: 2026-04-21
*/
package snakegame;

import java.awt.*;
import java.util.LinkedList;

/**
 * Snake class
 * -----------------------------------
 * Responsibility:
 * - Represents the snake in the game
 * - Stores snake body segments
 * - Handles movement and growth
 *
 * Relationships:
 * - Uses GamePanel to display itself (collaboration)
 * - Uses LinkedList<Point> to store body (data structure)
 *
 * Learning Outcomes:
 * - LO3: Objects and classes
 * - LO8: Generic collections (LinkedList)
 */
public class Snake {

    // LinkedList storing snake body positions
    private LinkedList<Point> body;

    // Current direction of movement
    private int dx; // change in x (columns)
    private int dy; // change in y (rows)

    /**
     * Constructor for Snake
     *
     * Initializes snake with a starting position and direction
     *
     * @param startRow initial row position
     * @param startCol initial column position
     * @return none
     */
    public Snake(int startRow, int startCol) {

        body = new LinkedList<>();

        // Add initial head position
        body.add(new Point(startCol, startRow));

        // Initial direction: moving right
        dx = 1;
        dy = 0;
    }

    /**
     * Moves the snake forward
     *
     * Adds a new head in the current direction
     * Removes the tail (unless growing)
     *
     * @param none
     * @return void
     */
    public void move() {

        // Get current head
        Point head = body.getFirst();

        // Calculate new head position
        int newX = head.x + dx;
        int newY = head.y + dy;

        // Add new head
        body.addFirst(new Point(newX, newY));

        // Remove tail (normal movement)
        body.removeLast();
    }

    /**
     * Grows the snake (used when food is eaten)
     *
     * Adds a new segment without removing the tail
     *
     * @param none
     * @return void
     */
    public void grow() {

        // Get current head
        Point head = body.getFirst();

        int newX = head.x + dx;
        int newY = head.y + dy;

        // Add new head, but DO NOT remove tail
        body.addFirst(new Point(newX, newY));
    }

    /**
     * Draws the snake on the GamePanel
     *
     * @param panel the GamePanel to draw on
     * @return void
     */
    public void draw(GamePanel panel) {

        for (Point p : body) {
            panel.setCellColor(p.y, p.x, Color.GREEN);
        }
    }

    /**
     * Sets the direction of the snake
     *
     * @param dx change in x direction
     * @param dy change in y direction
     * @return void
     */
    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets the snake body
     *
     * @param none
     * @return LinkedList<Point> body segments
     */
    public LinkedList<Point> getBody() {
        return body;
    }
}
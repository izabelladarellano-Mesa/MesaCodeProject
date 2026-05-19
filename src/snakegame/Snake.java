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
*Code snake game in Java. (2023, July 19). YouTube. https://youtu.be/Y62MJny9LHg?si=hgmfGnfVQsrohxyY
* <<Add more references here>>
*
* Version: 2026-05-19
*/
package snakegame;

import java.awt.Point;
import java.util.LinkedList;

/**
 * Snake class
 * -----------------------------------
 * Responsibility:
 * - Represents the snake
 * - Stores body segments
 * - Handles movement and growth
 *
 * - Relationships:
 * - Used by GamePanel to manage snake state
 * - Has-many body segments stored in LinkedList<Point>
 *
 * Learning Outcomes:
 * - LO3: Classes and objects
 * - LO8: Data structures
 */
public class Snake {

	// Snake has-many body segments stored as Points
	private LinkedList<Point> body;

	// Horizontal movement direction
	// -1 = left, 1 = right, 0 = no horizontal movement
	private int dx;

	// Vertical movement direction
	// -1 = up, 1 = down, 0 = no vertical movement
	private int dy;

	// Determines whether snake should grow
	// after the next movement update
	private boolean grow;

    /**
     * Constructor
     *
     * @param row starting row
     * @param col starting column
     * @return none
     */
    public Snake(int row, int col) {

        body = new LinkedList<>();
        //Point (x, y) = (col, row)
        body.add(new Point(col, row));

        dx = 1;
        dy = 0;

        grow = false;
    }

    /**
     * Moves snake one space
     *
     * @return void
     */
    public void move() {

        Point head = body.getFirst();

        int newX = head.x + dx;
        int newY = head.y + dy;

        body.addFirst(new Point(newX, newY));

        if (!grow) {
            body.removeLast();
        } else {
            grow = false;
        }
    }

    /**
     * Changes snake direction
     * Prevents reversing into itself
     * 
     * @param newDx changes in x direction
     * @param newDy changes in y direction
     * @return void
     */
    public void setDirection(int newDx, int newDy) {
    	//Prevent reverse movement
    	if (dx + newDx == 0 && dy + newDy == 0) {
    		return;
    	}
    	
    	dx = newDx;
    	dy = newDy;
    }
    /**
     * Causes snake to grow next move
     *
     * @return void
     */
    public void grow() {
        grow = true;
    }

    /**
     * Returns snake body
     *
     * @return LinkedList<Point>
     */
    public LinkedList<Point> getBody() {
        return body;
    }

    /**
     * Returns snake head
     *
     * @return Point head position
     */
    public Point getHead() {
        return body.getFirst();
    }
}
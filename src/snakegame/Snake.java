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
* Version: 2026-04-22
*/
package snakegame;

import java.awt.Point;
import java.util.LinkedList;

/**
 * Snake class
 * -----------------------------------
 * Responsibility:
 * - Represents snake
 * - Handles movement and growth
 *
 * Relationships:
 * - GamePanel uses Snake
 * - Uses LinkedList<Point>
 */
public class Snake {

    private LinkedList<Point> body;

    private int dx;
    private int dy;

    private boolean grow;

    /**
     * Constructor
     *
     * @param row starting row
     * @param col starting column
     */
    public Snake(int row, int col) {

        body = new LinkedList<>();

        body.add(new Point(col, row));

        dx = 1;
        dy = 0;

        grow = false;
    }

    /**
     * Moves snake
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
     * @return Point head location
     */
    public Point getHead() {
        return body.getFirst();
    }
}
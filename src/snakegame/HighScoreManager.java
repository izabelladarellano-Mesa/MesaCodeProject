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
* Used as a reference and help if needed
* <<Add more references here>>
*
* Version: 2026-05-20
*/
package snakegame;

import java.io.*;

/**
 * HighScoreManager class
 * -----------------------------------
 * Responsibility:
 * - Saves high score to file
 * - Loads high score from file
 * - Handles file IO operations
 *
 * Relationships:
 * - Used by GamePanel to save and load scores
 *
 * Learning Outcomes:
 * - LO5: Exception handling
 * - LO6: File IO
 */
public class HighScoreManager {

    // HighScoreManager stores score data in a text file
    private static final String FILE_NAME = "highscore.txt";

    /**
     * Saves high score to file
     *
     * @param score score to save
     */
    public void saveHighScore(int score) {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(FILE_NAME))) {

            writer.println(score);

        } catch (IOException e) {

            System.out.println(
                    "Error saving high score."
            );

            e.printStackTrace();
        }
    }

    /**
     * Loads high score from file
     *
     * @return saved high score
     */
    public int loadHighScore() {

        File file = new File(FILE_NAME);

        // Return 0 if file does not exist yet
        if (!file.exists()) {

            return 0;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            return Integer.parseInt(
                    reader.readLine()
            );

        } catch (IOException
                 | NumberFormatException e) {

            System.out.println(
                    "Error loading high score."
            );

            e.printStackTrace();

            return 0;
        }
    }
}
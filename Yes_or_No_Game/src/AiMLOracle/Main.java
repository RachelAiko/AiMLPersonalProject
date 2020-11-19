/**
 * AUTH: Rachel Matthews
 * DATE: Monday, Oct 12th, 2020
 * PROJ: Fruit Guessing Game for AiML Oracle course
 * FILE: Main.java
 *
 * Defines the Main driver class.
 */

package AiMLOracle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static final String QUESTIONS_FILE = "questions.txt";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        System.out.println("Welcome to the Fruit Guessing Game!");
        System.out.println();

        QuestionTree questions = new QuestionTree();
        if (questions.yesTo("Do you want to use the tree from the previous game?"))
            questions.read(new Scanner(new File(QUESTIONS_FILE)));
        System.out.println();

        do {
            System.out.println("Please think of an fruit for me to guess.");
            questions.questions();
            System.out.println();
        } while (questions.yesTo("Do you want to go again?"));
        System.out.println();
        System.out.println("Thanks for playing!");
        questions.write(new PrintStream(new File(QUESTIONS_FILE)));
    }
}





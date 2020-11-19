/**
 * AUTH: Rachel Matthews
 * DATE: Monday, Oct 12th, 2020
 * PROJ: Fruit Guessing Game for AiML Oracle course
 * FILE: QuestionTree.java
 *
 * Defines the QuestionTree class.
 */

package AiMLOracle;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class implements a yes/no guessing game
 * using a binary tree that asks the user a series
 * of yes or no questions. If answer is not in tree,
 *  the binary tree will be updated with the answer and
 *  a question that applies to that answer.
 */
public class QuestionTree {

  /**
   * The root of the binary tree storing the questions and answers
   */

  private QuestionNode root;
  /**
   * Records the user's input.
   */
  private final Scanner userResponse;

  /**
   * Constructs a question tree with one leaf node (answer node)
   * representing the fruit strawberry.
   */
  public QuestionTree() {
    root = new QuestionNode("strawberry");
    userResponse = new Scanner(System.in);
  }

  /**
   * replaces the current tree available by reading entire
   * line of input to construct a tree based on a file.
   * @param input from user
   */
  public void read(Scanner input) {
    while(input.hasNextLine()) {
      root = reading(input);
    }
  }

  /**
   * Method that reads entire lines of input to
   * construct a tree based on a file.
   * @param input from user
   * @return root
   */
  private QuestionNode reading(Scanner input) {
    String type = input.nextLine();
    String data = input.nextLine();
    QuestionNode root = new QuestionNode(data);

    if (type.contains("Question:")) {
      root.yesNode = reading(input);
      root.noNode = reading(input);
    }
    return root;
  }

  /**
   *  Stores the current tree to an output file. If PrintStream
   *   // is not open for writing, throws an IllegalArgumentException
   * @param output
   */
  public void write(PrintStream output) {
    if (output == null) {
      throw new IllegalArgumentException();
    }
    createTree(root, output);
  }

  /**
   * A private method that creates the current tree to
   *   // an input file.
   * @param rootOfTree
   * @param output
   */
  private void createTree(QuestionNode rootOfTree, PrintStream output) {
    if (isAnswerNode(rootOfTree)) {
      output.println("Answer:");
      output.println(rootOfTree.data);
    } else {
      output.println("Question:");
      output.println(rootOfTree.data);
      createTree(rootOfTree.yesNode, output);
      createTree(rootOfTree.noNode, output);
    }
  }

  /**
   * Uses current tree to ask the user a series of yes/no questions
   * until the program guesses their object correctly or fails.
   * If it fails to guess correctly it  expands the tree to include their fruit and a new
   * question to distinguish their fruit from the others within the tree
   */
  public void questions() {
    root = questions(root);
  }

  private QuestionNode questions(QuestionNode current) {
    if (isAnswerNode(current)) {
      if (yesTo("Would your fruit happen to be " + current.data +"?")) {
        System.out.println("Wow, I got it right!");
        System.out.println("Computer for the win!");
      } else {
        System.out.print("What is the name of your fruit? ");
        QuestionNode answer = new QuestionNode(userResponse.nextLine());
        System.out.println("Please give me a yes/no question that");
        System.out.println("distinguishes between your fruit and mine: ");
        String question = userResponse.nextLine();
        if (yesTo("What is the answer for your question?")) {
          current = new QuestionNode(question, answer, current);
        } else {
          current = new QuestionNode(question, current, answer);
        }
        System.out.println("Thank you for teaching me.");
      }

    } else {
      if (yesTo(current.data)) {
        current.yesNode = questions(current.yesNode);
      } else {
        current.noNode = questions(current.noNode);
      }
    }
    return current;
  }

  /**
   * Asks the user a question, with an answer of "y " or "n";
   * returns true if the answer was yes, returns false otherwise
   * @param prompt
   * @return
   */
  public boolean yesTo(String prompt) {
    System.out.print(prompt + " (y/n)? ");
    String response = userResponse.nextLine().trim().toLowerCase();
    while (!response.equals("y") && !response.equals("n")) {
      System.out.println("Please answer y or n.");
      System.out.print(prompt + " (y/n)? ");
      response = userResponse.nextLine().trim().toLowerCase();
    }
    return response.equals("y");
  }

  /**
   * method that determines whether a specific node
   *   // is a leaf node/answer node
   * @param node
   * @return
   */
  private boolean isAnswerNode(QuestionNode node) {
    return (node.yesNode == null || node.noNode == null);
  }
}


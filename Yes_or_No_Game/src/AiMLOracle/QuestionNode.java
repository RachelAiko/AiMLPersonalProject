/**
 * AUTH: Rachel Matthews
 * DATE: Monday, Oct 12th, 2020
 * PROJ: Fruit Guessing Game for AiML Oracle course
 * FILE: QuestionNode.java
 *
 * Defines the QuestionNode class.
 */

package AiMLOracle;

/**
 * This class implements an binary tree system based on yes/no responses
 * and constructors.
 */
public class QuestionNode {

  /**
   *  Data node that will hold either a fruit or a question that corresponds to that fruit
   *  */
  public String data;

  public QuestionNode yesNode;

  /**
   *  Right branch of the binary tree, representing the path the tree would go if the user responded "no".
   */
  public QuestionNode noNode;

  /**
   * constructs a leaf node with given data
   * node that stores an answer
   * @param data
   */
  public QuestionNode(String data) {
    this(data, null, null);
  }

  /**
   * constructs a branch node with given data, left subtree,
   *   // and right subtree
   *   // node that stores an question
   * @param data
   * @param yesNode
   * @param noNode
   */
  public QuestionNode(String data, QuestionNode yesNode,
      QuestionNode noNode) {
    this.data = data;
    this.yesNode = yesNode;
    this.noNode = noNode;
  }

}

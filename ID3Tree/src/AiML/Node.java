package AiML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Node {

  private List<Node> children = new ArrayList<Node>();
  private Node parent;
  private String data;
  private NodeType type;

  public Node() {
  }

  public Node(String data) {
    setData(data);
  }

  // Set the data value of the current node
  public void setData(String data) {
    this.data = data;
  }

  // Get the data value of the current node
  public String getData() {
    return data;
  }

  // Return an ArrayList of nodes containing all of the children under a node
  public List<Node>getChildren() {
    return children;
  }

  // Add a child noe to the current node
  public void addChild(Node node) {
    node.parent = this;
    this.children.add(node);
  }

  // Remove all children from a node
  public void removeChildren() {
    children = new ArrayList<Node>();
  }

  // Returns the value of the parent node
  public Node getParent() {
    return parent;
  }

  // Print all nodes from the current node
  public void print(String prefix, boolean isTail) {
    System.out.println(prefix + (isTail ? "\\-- " : "|-- ") + data);
    for (int i = 0; i < children.size() - 1; i++) {
      children.get(i).print(prefix + (isTail ? " " : "| "), false);
    }
    if (children.size() > 0) {
      children.get(children.size() - 1)
          .print(prefix + (isTail ?" " : "| "), true);
    }
  }
  public enum NodeType {
    ROOTNODE,
    LEAFNODE,
    BRANCH
  }

  public List<ArrayList<String>> loadCSV(String filepath) throws
      FileNotFoundException {
    List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    Scanner scan = new Scanner(new File(filepath));
    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      ArrayList<String> lineArrayList = new
          ArrayList<String>(Arrays.asList(line.split(",")));
      data.add(lineArrayList);
    }
    return data;
  }

  static public void printArrayList(List<ArrayList<String>> data) {
    //record that largest string length in each column for formatting
    int colnum = 0;
    List<Integer> maxcolwidths = new ArrayList<Integer>();
    for(ArrayList<String> row : data) {
      for (String item : row) {
        if( maxcolwidths.size() <= colnum) {
          maxcolwidths.add(item.length());
        }
        else if (item.length() > maxcolwidths.get(colnum)) {
          maxcolwidths.set(colnum,item.length());
        }
        colnum++;
      }
      colnum=0;
    }
  }
   /* colnum = 0;
    for(ArrayList<String> row : data) {
    for (String item : row) {
      String format = "| %-" + maxcolwidths.get(colnum) + "s";
      System.out.printf(format,item);
      colnum++;
    }
    colnum = 0;
    System.out.println();
  }*/
}

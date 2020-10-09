/* Oracle AiML course : Node object class that contains Tree Traversal Recursive Methods */

public class Node {

    int data;       // properties of Node object
    Node left;
    Node right;

    public Node(int data) {     // constructor that takes data as an integer

        this.data = data;
        left = null;
        right = null;
    }

    // methods to manipulate node attributes (getters and setters)
   public void setLeft(Node node) {    // adds a node to the current left node. If current left node is null, set left equal to node.
        if (left == null)
            left = node;
    }

    public void setRight(Node node) {   // adds a node to the current right node. If current right node is null, set right equal to node.
        if (right == null)
            right = node;
    }

    public Node getLeft() {     // returns the current left node
        return left;
    }

    public Node getRight() {    // returns the current right node
        return right;
    }

    public int getData() {     // returns the data value of current node
        return data;
    }

    public void setData(int data) {     // set the data value of current node
        this.data = data;
    }


    // recursive tree traversal methods
    // pre-order traversal
    void printPreOrder(Node node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    // post-order traversal
    void printPostOrder(Node node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPostOrder(node.left);
        printPostOrder(node.right);
    }
    
    // in-order traversal
    void printInOrder(Node node) {

        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

}

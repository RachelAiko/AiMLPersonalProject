/* Driver Class for Node */

public class NodeDriver {

    public static void main(String[] args) {
        
        // creates the nodes of the binary tree
        Node root  = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        
        // creates the binary tree itself
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node7);
        root.setRight(node3);
        node3.setRight(node6);

        root.printInOrder(root);        // calls method to print In Order traversal
        System.out.println();
        root.printPostOrder(root);      // calls method to print Post Order traversal
        System.out.println();
        root.printPreOrder(root);       // calls method to print Pre Order traversal
    }
}

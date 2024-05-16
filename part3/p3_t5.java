package part3;

public class p3_t5 {
    // Node class representing each node in the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // BinaryTree class containing methods to create, display, check emptiness, and delete the binary tree
    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        // Method to insert a new node with the given data
        void insert(int data) {
            root = insertRec(root, data);
        }

        // A recursive function to insert a new data in the binary tree
        Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        // Method to check if the binary tree is empty
        boolean isEmpty() {
            return root == null;
        }

        // Method to delete the entire binary tree
        void deleteTree() {
            root = null;
        }

        // Method to display the binary tree (inorder traversal)
        void display() {
            displayRec(root);
            System.out.println();
        }

        void displayRec(Node root) {
            if (root != null) {
                displayRec(root.left);
                System.out.print(root.data + " ");
                displayRec(root.right);
            }
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            // Inserting nodes into the tree
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            System.out.println("Binary Tree:");
            tree.display();

            // Checking if the tree is empty
            System.out.println("Is the tree empty? " + tree.isEmpty());

            // Deleting the entire tree
            tree.deleteTree();
            System.out.println("Binary Tree after deletion:");
            tree.display();
            System.out.println("Is the tree empty after deletion? " + tree.isEmpty());
        }
    }

}

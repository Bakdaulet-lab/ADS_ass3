package part3;

public class p3_t3 {
    // Node class representing each node in the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // BinaryTree class containing methods to create, display, and count even/odd elements in the binary tree
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

        // Method to count the number of even and odd elements in the binary tree
        void countEvenOdd() {
            int[] count = {0, 0}; // Index 0 for even count, Index 1 for odd count
            countEvenOddRec(root, count);
            System.out.println("Number of even elements: " + count[0]);
            System.out.println("Number of odd elements: " + count[1]);
        }

        // A recursive function to count even and odd elements in the binary tree
        void countEvenOddRec(Node root, int[] count) {
            if (root != null) {
                if (root.data % 2 == 0) {
                    count[0]++; // Increment even count
                } else {
                    count[1]++; // Increment odd count
                }
                countEvenOddRec(root.left, count);
                countEvenOddRec(root.right, count);
            }
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

            // Counting even and odd elements in the tree
            tree.countEvenOdd();
        }
    }


}

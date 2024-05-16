package part3;

public class  p3_t2 {
    // Node class representing each node in the binary tree
    static class  Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // BinaryTree class containing methods to create, display, and remove nodes from the binary tree
    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        // Method to insert a new node with the given key
        void insert(int key) {
            root = insertRec(root, key);
        }

        // A recursive function to insert a new key in the binary tree
        Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            return root;
        }

        // Method to remove a node with the given key
        void remove(int key) {
            root = removeRec(root, key);
        }

        // A recursive function to remove a key in the binary tree
        Node removeRec(Node root, int key) {
            if (root == null) return root;

            if (key < root.key) {
                root.left = removeRec(root.left, key);
            } else if (key > root.key) {
                root.right = removeRec(root.right, key);
            } else {
                // Node with only one child or no child
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;

                // Node with two children: Get the inorder successor (smallest in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = removeRec(root.right, root.key);
            }
            return root;
        }

        int minValue(Node root) {
            int minValue = root.key;
            while (root.left != null) {
                minValue = root.left.key;
                root = root.left;
            }
            return minValue;
        }

        // Method to display the binary tree (inorder traversal)
        void display() {
            displayRec(root);
        }

        void displayRec(Node root) {
            if (root != null) {
                displayRec(root.left);
                System.out.print(root.key + " ");
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
            System.out.println();

            // Removing a node from the tree
            System.out.println("Removing 20 from the tree:");
            tree.remove(20);
            tree.display();
        }
    }

}



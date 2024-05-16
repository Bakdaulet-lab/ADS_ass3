package part3;
public class p3_t1 {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class BinaryTree {
        TreeNode root;

        BinaryTree() {
            root = null;
        }

        void insert(int data) {
            root = insertRec(root, data);
        }

        TreeNode insertRec(TreeNode root, int data) {
            if (root == null) {
                root = new TreeNode(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        void display() {
            displayTree(root);
        }

        void displayTree(TreeNode root) {
            if (root != null) {
                displayTree(root.left);
                System.out.print(root.data + " ");
                displayTree(root.right);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        System.out.println("Binary Tree:");
        tree.display();
    }
}



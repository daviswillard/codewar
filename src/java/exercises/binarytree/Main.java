package exercises.binarytree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                2, new TreeNode(1, null, null), new TreeNode(3, null, null)
        );
        TreeNode newRoot = new Main().invertTree(root);
        System.out.println(root.val + " " + root.left.val + " " + root.right.val);
        System.out.println(newRoot.val + " " + newRoot.left.val + " " + newRoot.right.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.right = invertTree(root.left);
        newRoot.left = invertTree(root.right);
        return newRoot;
    }
}

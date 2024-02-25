package BinaryTree;

/**
 * https://leetcode.com/problems/invert-binary-tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        //Base case.
        if (root == null)
        {
            return null;
        }

        //Call invertTree recursively.
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //Swap left and right nodes.
        root.left = right;
        root.right = left;

        return root;
    }
}

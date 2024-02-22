package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfBinaryTree {
    /**
     * Base case is if root is null, return 0. When function is called recursively
     * it will continue until base case is found, i.e. the left and right nodes are null
     * and the current root is the deepest leaf node.
     * Once finished, the branches are then compared to find the max, and 1 is added for 
     * the original root node.
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * Iterative DFS approach by user 'yfcheng' in submissions.
     */
    public int maxDepthDFS(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(max, temp);

            if (node.left != null)
            {
                stack.push(node.left);
                value.push(temp + 1);
            }

            if (node.right != null)
            {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        
        return max;
    }

    /**
     * Iterative BFS approach by user 'yfcheng' in submissions.
     */
    public int maxDepthBFS(TreeNode root)
    {
        if(root == null) 
        {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()) 
        {
            int size = queue.size();

            while(size > 0) 
            {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }

            count++;
        }

        return count;
    }
}

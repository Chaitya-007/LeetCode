/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int maxi;

    public int fun(TreeNode node)
    {

        if(node == null)
        {
            return 0;
        }

        int leftsum = Math.max(0, fun(node.left));
        int rightsum = Math.max(0, fun(node.right));

        maxi = Math.max(maxi, node.val + leftsum + rightsum);

        return node.val + Math.max(leftsum,rightsum);
    }

    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        fun(root);
        return maxi;
        
    }
}
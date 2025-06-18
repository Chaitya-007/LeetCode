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
   private int maxSum;

    public int ht(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }

        int left = ht(node.left);
        int right = ht(node.right);
        
        maxSum = Math.max(maxSum, left + right);

        return 1 + Math.max(left,right);
    }

    

    public int diameterOfBinaryTree(TreeNode root) {
        //your code goes here
        maxSum = 0;
         ht(root);
         return maxSum;
    }
}
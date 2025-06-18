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
    public int maxDepth(TreeNode root) {
        //your code goes here
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return 0;
        q.offer(root);
        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            if(size > 0) level++;
            
            while(size > 0)
            {
            TreeNode node = q.poll();
            
            if(node.left != null)
            {
                q.offer(node.left);
            }
            if(node.right != null)
            {
                q.offer(node.right);
            }
            size--;

            }
        }

        return level;
    }
}
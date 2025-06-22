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

    public void preorder(TreeNode node,int level, List<Integer> list)
    {
        if(node == null) return;

        if(level == list.size())
        {
            list.add(node.val);
        }

        preorder(node.right,level + 1, list);
        preorder(node.left,level + 1, list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        //your code goes here
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        preorder(root,0,list);
        return list;
    }
}
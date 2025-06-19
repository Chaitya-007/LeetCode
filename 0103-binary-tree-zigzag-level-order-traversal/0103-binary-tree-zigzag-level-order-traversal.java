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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        boolean flag = true;

        while(!q.isEmpty())
        {
            int size = q.size();
            Deque<Integer> level = new ArrayDeque<>();

            while(size > 0)
            {
                TreeNode node = q.poll();

                if(flag)
                {
                    level.offerLast(node.val);
                }
                else
                {
                    level.offerFirst(node.val);
                }

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

            list.add(new ArrayList<>(level));

            flag = !flag;
        }

        return list;
    }
}
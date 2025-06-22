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
class CustomNode
{
    TreeNode node;
    int row;
    int col;

    public CustomNode(TreeNode n,int r,int c)
    {
        this.node = n;
        this.row = r;
        this.col = c;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getCol()
    {
        return this.col;
    }

    public TreeNode getNode()
    {
        return this.node;
    }
}

class Tuple
{
    int row;
    int val;

    public Tuple(int r,int val)
    {
        this.row = r;
        this.val = val;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getVal()
    {
        return this.val;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //your code goes here
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Comparator<Tuple> cmp = (p,q) -> 
        {
            if(p.getRow() == q.getRow())
            {
                return Integer.compare(p.getVal(),q.getVal());
            }

                return Integer.compare(p.getRow(),q.getRow());

        };

        TreeMap<Integer, PriorityQueue<Tuple>> map = new TreeMap<>();  

        Queue<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root,0,0));

        while(!q.isEmpty())
        {
            CustomNode c = q.poll();
            TreeNode node = c.getNode();
            int row = c.getRow();
            int col = c.getCol();


            if(map.containsKey(col))
            {
                PriorityQueue<Tuple> pq = map.get(col);
                pq.offer(new Tuple(row,node.val));
                map.put(col,new PriorityQueue<>(pq));
            }
            else 
            {
                PriorityQueue<Tuple> pq = new PriorityQueue<>(cmp);
                pq.offer(new Tuple(row,node.val));
                map.put(col,new PriorityQueue<>(pq));
            }

            if(node.left != null) q.offer(new CustomNode(node.left,row + 1, col - 1));
            if(node.right != null) q.offer(new CustomNode(node.right,row + 1, col + 1));
        }

        for(Map.Entry<Integer, PriorityQueue<Tuple>> e : map.entrySet())
        {
            PriorityQueue<Tuple> pq = e.getValue();
            List<Integer> temp = new ArrayList<>();
            while(!pq.isEmpty())
            {
                Tuple t = pq.poll();
                temp.add(t.getVal());
            }

            list.add(temp);
        }

        return list;


    }   
}
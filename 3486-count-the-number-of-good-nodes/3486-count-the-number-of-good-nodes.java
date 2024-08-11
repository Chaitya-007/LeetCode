class Solution {

    public int fun(int node, int parent, List<List<Integer>> adjList, int[] subtreeSize, boolean[] isGood)
    {
        int size = 1; // size of node itself
        int firstChildSize = -1; // to store size of firstChild, will use to compare with the size of second child

        for(int neighbour : adjList.get(node))
        {
            if(neighbour != parent) // avoiding visiting parent again 
            {
                int childSize = fun(neighbour,node,adjList,subtreeSize,isGood);
                size += childSize;

                if(firstChildSize == -1)
                {
                    firstChildSize = childSize; // store size of firstChild
                }
                else if(firstChildSize != childSize) // if size of firstChild is not equal to secondChild then mark it as false
                {
                    isGood[node] = false;
                }
            }
        }

        subtreeSize[node] = size;
        return size;
    }
    
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1; // no. of nodes = no. of edges + 1

        List<List<Integer>> adjList = new ArrayList<> ();

        for(int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] adj : edges)
        {
            int u = adj[0];
            int v = adj[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] subtreeSize = new int[n]; // to store the size of nodes
        boolean[] isGood = new boolean[n]; // to mark wheter the node is good or not
        
        Arrays.fill(isGood,true);

        fun(0,-1,adjList,subtreeSize,isGood);
        int count = 0;

        for(boolean good : isGood)
        {
            if(good)
            {
                count++;
            }
        }

        return count;
   
    }
    

}
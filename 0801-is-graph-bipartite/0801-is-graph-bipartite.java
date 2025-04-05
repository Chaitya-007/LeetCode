class Solution {


    public boolean dfs(int node, int[] color, int col, int[][] graph)
    {
        color[node] = col;

        for(int adjNode : graph[node])
        {
            if(color[adjNode] == -1)
            {
                if(dfs(adjNode, color, col == 1 ? 0 : 1, graph) == false) return false;
            }
            else
            {
                if(color[adjNode] == col) return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;

        int[] color = new int[v];
        Arrays.fill(color,-1);

        for(int i = 0; i < v; i++)
        {
            if(color[i] == -1)
            {
                if(dfs(i,color,1,graph) == false) return false;
            }
        }

        return true;

    }
}
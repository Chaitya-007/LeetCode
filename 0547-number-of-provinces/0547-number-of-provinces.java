class Solution {

    public void dfsFunc(int node, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(Integer it : adj.get(node))
        {
            if(vis[it] != 1)
            {
                dfsFunc(it,vis,adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = isConnected.length;

        for(int i = 0; i < (V+1); i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(i != j && isConnected[i][j] == 1)
                {
                    int u = i + 1;
                    int v = j + 1;
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }

        int[] vis = new int[V+1];
        Arrays.fill(vis,0);
        int cnt = 0;

        for(int node = 1; node <= V; node++)
        {
            if(vis[node] != 1)
            {
                dfsFunc(node,vis,adj);
                cnt++;
            }
        }

        return cnt;

    }
}
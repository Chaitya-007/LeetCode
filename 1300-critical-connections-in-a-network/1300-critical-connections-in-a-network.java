class Solution {

    int timer = 1;

       public void dfs(int node,int parent,boolean[] vis,List<List<Integer>> adj,List<List<Integer>> ans,int[] startingTime,int[] lowest)
    {
        vis[node] = true;
        startingTime[node] = timer;
        lowest[node] = timer;
        timer++;

        for(Integer adjNode : adj.get(node))
        {
            if(!vis[adjNode])
            {
                dfs(adjNode,node,vis,adj,ans,startingTime,lowest);
            }
        }

        if(parent != -1)
        {
        for(Integer adjNode : adj.get(node))
        {
            if(adjNode != parent)
            {
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
            }
        }

        if(lowest[node] > startingTime[parent])
        {
            List<Integer> list = new ArrayList<>();
            list.add(node);
            list.add(parent);
            ans.add(new ArrayList<>(list));
        }

        }

    }

    // public void dfs(int node,int parent,boolean[] vis,List<List<Integer>> adj,List<List<Integer>> ans,int[] startingTime,int[] lowest)
    // {
    //     vis[node] = true;
    //     startingTime[node] =  lowest[node] = timer;
    //     timer++;
       

    //     for(Integer adjNode : adj.get(node))
    //     {
    //         if(adjNode == parent) continue;

    //         if(!vis[adjNode])
    //         {
    //             dfs(adjNode,node,vis,adj,ans,startingTime,lowest);
    //             lowest[node] = Math.min(lowest[node], lowest[adjNode]);
    //             if(lowest[adjNode] > startingTime[node])
    //             {
    //                 List<Integer> list = new ArrayList<>();
    //                 list.add(adjNode);
    //                 list.add(node);
    //                 ans.add(new ArrayList<>(list));
    //             }
    //         }
    //         else
    //         {
    //             // You are coming by visiting all the node via dfs
    //             lowest[node] = Math.min(lowest[node],lowest[adjNode]);
    //         }
    //     }

    // }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < connections.size(); i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];

        int[] startTiming = new int[n];
        int[] lowest = new int[n];

        dfs(0,-1,vis,adj,ans,startTiming,lowest);
        return ans;
    }
}
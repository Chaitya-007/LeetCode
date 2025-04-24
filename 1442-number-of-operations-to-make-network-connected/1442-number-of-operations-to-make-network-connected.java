class Disjoint
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n)
    {
        for(int i = 0; i < n; i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node)
    {
        if(node == parent.get(node))
        {
            return node;
        }

        int updPar = findUpar(parent.get(node));
        parent.set(node, updPar);
        return updPar;
    }

    public void unionBySize(int u,int v)
    {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));

        }
     }

}


class Solution {

    public void dfs(int node,boolean[] vis, List<List<Integer>> adj)
    {
        vis[node] = true;

        for(Integer adjNode : adj.get(node))
        {
            if(!vis[adjNode])
            {
                dfs(adjNode,vis,adj);
            }
        }
    }



    public int makeConnected(int n, int[][] connections) {

        Disjoint ds = new Disjoint(n);

        int extraEdges = 0;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int nc = 0;

        // boolean[] vis = new boolean[n];

        // for(int i = 0; i < n; i++)
        // {
        //     if(!vis[i])
        //     {
        //         nc++;
        //         dfs(i,vis,adj);
        //     }
        // }

        for(int i = 0; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUpar(u) == ds.findUpar(v))
            {
                extraEdges++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }

        for(int i = 0; i < ds.parent.size(); i++)
        {
            if(ds.parent.get(i) == i)
            {
                nc++;
            }
        }

        return (nc - 1) <= extraEdges ? (nc - 1) : -1;
        
    }
}
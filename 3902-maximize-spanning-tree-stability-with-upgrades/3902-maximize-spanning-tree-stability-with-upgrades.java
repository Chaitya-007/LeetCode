class DisjointSet
{
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n)
    {
        parent = new ArrayList<>();
        size = new ArrayList<>();
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
        parent.set(node,updPar);
        return updPar;
    }

    public void unionBySize(int u, int v)
    {
        int upar = findUpar(u);
        int vpar = findUpar(v);

        if(upar == vpar) return;

        if(size.get(upar) < size.get(vpar))
        {
            size.set(vpar, size.get(upar) + size.get(vpar));
            parent.set(upar, vpar);
        }
        else
        {
            size.set(upar, size.get(upar) + size.get(vpar));
            parent.set(vpar, upar);

        }
    }
}

class CustomNode
{
    int u;
    int v;

    public CustomNode(int u, int v)
    {
        this.u = u;
        this.v = v;
    }

    public int getU()
    {
        return this.u;
    }

    public int getV()
    {
        return this.v;
    }
}



class Solution {

    public boolean  canBuild(int n, int[][] edges, int k, int stability)
    {
        DisjointSet ds = new DisjointSet(n);
        List<CustomNode> list = new ArrayList<>();

        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int s = edges[i][2];
            int m = edges[i][3];

            if(m == 1)
            {
                if(s < stability) return false;
                ds.unionBySize(u,v);
            }
            else
            {
                if(s >= stability) 
                {
                    ds.unionBySize(u,v);
                    
                }
                else if(2 * s >= stability)
                {
                    list.add(new CustomNode(u,v));
                }
            }
        }

        int updates = 0;

        for(CustomNode c : list)
        {
            int u = c.getU();
            int v = c.getV();

            if(ds.findUpar(u) != ds.findUpar(v))
            {
                if(++updates > k)
                {
                    return false;
                }
                else
                {
                    ds.unionBySize(u,v);
                }
            }
        }

        int root = ds.findUpar(0);

        for(int i = 1; i < n; i++)
        {
            if(ds.findUpar(root) != ds.findUpar(i)) return false;
        }

        return true;
    }



    public int maxStability(int n, int[][] edges, int k) {
        DisjointSet ds = new DisjointSet(n);

        int low = 1;
        int high = 0;

        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int s = edges[i][2];
            int m = edges[i][3];

            if(m == 1)
            {
                // one line that returns -1 is missing
                // If all edges are mandatory and if it forms a cycle then we can never form a spanning tree
                if(ds.findUpar(u) == ds.findUpar(v)) return -1;
                ds.unionBySize(u,v);
                high = Math.max(high,s);
            }
            else
            {
                high = Math.max(high, 2*s);
            }
        }

        int ans = -1;
        while(low <= high)
        {
            int mid = (low + high) >> 1;

            if(canBuild(n,edges,k,mid))
            {
                ans = mid;
                // Since we want to maximise => we will move forward
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return ans;
    }
}
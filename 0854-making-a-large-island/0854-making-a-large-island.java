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
        parent.set(node,updPar);
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
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Disjoint ds = new Disjoint(n*m);

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    int row = i;
                    int col = j;
                    int node = row * m + col;


                    for(int k = 0; k < 4; k++)
                    {
                        int nrow = row + delRow[k];
                        int ncol = col + delCol[k];
                        int currnode = nrow*m + ncol;

                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && ds.findUpar(node) != ds.findUpar(currnode))
                        {
                            ds.unionBySize(node,currnode);
                        }
                    }


                }
            }
        }

        int maxo = 0;

        boolean haszero = false;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 0)
                {
                    haszero = true;
                    int row = i;
                    int col = j;
                    int node = row * m + col;

                    HashSet<Integer> set = new HashSet<>();

                    for(int k = 0; k < 4; k++)
                    {
                        int nrow = row + delRow[k];
                        int ncol = col + delCol[k];
                        int currnode = nrow*m + ncol;

                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1)
                        {
                            int ulp = ds.findUpar(currnode);
                            set.add(ulp);
                        }
                    }

                    Iterator<Integer> it = set.iterator();

                    int ans = 1;

                    while(it.hasNext())
                    {
                        int par = it.next();
                        ans += ds.size.get(par);
                    }

                    maxo = Math.max(ans,maxo);

                }
            }
        }


        return haszero ? maxo : (n*m);

        
    }
}
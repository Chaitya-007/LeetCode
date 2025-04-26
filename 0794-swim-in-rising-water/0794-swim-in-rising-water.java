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
    public int swimInWater(int[][] grid) {
        List<Integer> positions = new ArrayList<>();

        int n = grid.length;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                positions.add((i*n + j));
            }
        }

        Comparator<Integer> cmp = (p,q) ->
        {
            int row = p/n;
            int col = p%n;

            int nextrow = q/n;
            int nextcol = q%n;

            // Sorting in Increasing Order
            return Integer.compare(grid[row][col],grid[nextrow][nextcol]);

        };

        Collections.sort(positions,cmp);

        Disjoint ds = new Disjoint(n*n);

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(Integer position : positions)
        {
            int row = position/n;
            int col = position%n;

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[row][col] > grid[nrow][ncol])
                {
                    ds.unionBySize(position, nrow*n + ncol);
                }
            }

            if(ds.findUpar(0) == ds.findUpar(n*n - 1))
            {
                return grid[row][col];
            }
        }

        return -1;
    }
}
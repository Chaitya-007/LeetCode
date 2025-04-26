class CustomNode
{
    int val;
    int row;
    int col;

    public CustomNode(int v,int r, int c)
    {
        this.val = v;
        this.row = r;
        this.col = c;
    }

    public int getVal()
    {
        return val;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }
}


class Solution {
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        int[][] dis = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }

        dis[0][0] = grid[0][0];

        Comparator<CustomNode> cmp = (p,q) -> 
        {
            return Integer.compare(p.getVal(),q.getVal());
        };

        PriorityQueue<CustomNode> pq = new PriorityQueue<>(cmp);
        pq.offer(new CustomNode(grid[0][0],0,0));

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!pq.isEmpty())
        {
            CustomNode c = pq.poll();
            int val = c.getVal();
            int row = c.getRow();
            int col = c.getCol();

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n)
                {
                    int maxo = Math.max(val,grid[nrow][ncol]);
                    if(dis[nrow][ncol] > maxo)
                    {
                        dis[nrow][ncol] = maxo;
                        if(nrow == n - 1 && ncol == n - 1)
                        {
                            return dis[n-1][n-1];
                        }
                        pq.offer(new CustomNode(dis[nrow][ncol],nrow,ncol));
                    }

                }

            }
        
        }

            return dis[n-1][n-1];

    }
}
class Pair
{
    int diff;
    int row;
    int col;

    public Pair(int d,int r,int c)
    {
        this.diff = d;
        this.row = r;
        this.col = c;
    }

    public int getDiff()
    {
        return diff;
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

    public int fun(int row,int col,int prev,int maxdiff,boolean[][] vis,int[] delRow,int[] delCol,int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(row == n - 1 && col == m - 1)
        {
            return maxdiff;
        }

        vis[row][col] = true;
        int mino = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol])
            {
                int currdiff = Math.abs(grid[nrow][ncol] - prev);
                int getDiff = fun(nrow,ncol,grid[nrow][ncol],Math.max(maxdiff,currdiff),vis,delRow,delCol,grid);
                if(getDiff != Integer.MAX_VALUE)
                {
                    mino = Math.min(mino,getDiff);
                }
            }
        }

        vis[row][col] = false;
        return mino;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        // boolean[][] vis = new boolean[n][m];

        int[] delRow = {0,-1,0,1};
        int[] delCol = {-1,0,1,0};

        // int ans = fun(0,0,heights[0][0],0,vis,delRow,delCol,heights);
        // return ans;

        Comparator<Pair> cmp = (p,q) -> 
        {
            return Integer.compare(p.getDiff(),q.getDiff());
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
        pq.offer(new Pair(0,0,0));

        int[][] dis = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = 0;

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int diff = p.getDiff();
            int row = p.getRow();
            int col = p.getCol();

            if(row == n - 1 && col == m - 1)
            {
                break;
            }

                for(int i = 0; i < 4; i++)
                {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m)
                    {
                        int currdiff = Math.abs(heights[nrow][ncol] - heights[row][col]);
                        int maxdiff = Math.max(diff,currdiff);
                        if(maxdiff < dis[nrow][ncol])
                        {
                            dis[nrow][ncol] = maxdiff;
                            pq.offer(new Pair(maxdiff,nrow,ncol));
                        }
                    }
                }

        }

        return dis[n-1][m-1];

        
    }
}
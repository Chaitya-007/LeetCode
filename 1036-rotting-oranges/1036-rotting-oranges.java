class Pair
{
    int row;
    int col;
    int time;

    public Pair(int row_,int col_, int time_)
    {
        this.row = row_;
        this.col = col_;
        this.time = time_;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getTime()
    {
        return time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int cntFresh = 0;

        Queue<Pair> q = new LinkedList<Pair>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    vis[i][j] = 2;
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1)
                {
                    cntFresh++;
                }
            }
        }

        int cnt = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int tm = 0;

        while(!q.isEmpty())
        {
            int r = q.peek().getRow();
            int c = q.peek().getCol();
            int t = q.peek().getTime();
            q.poll();
            tm = Math.max(t,tm);

            for(int i = 0; i < 4; i++)
            {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1)
                {
                    cnt++;
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                }
            }
        }

        if(cntFresh != cnt) return -1;

        return tm;

        
    }
}
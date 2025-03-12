class Pair
{
    int row;
    int col;
    int steps;

    public Pair(int row_, int col_, int steps_)
    {
        this.row = row_;
        this.col = col_;
        this.steps = steps_;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getSteps()
    {
        return steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {


        // T.C -> O(N*M) + O(N*M*4)
        // S.C -> O(N*M) + O(N*M)
        int n = mat.length;
        int m = mat[0].length;

        int[][] grid = new int[n][m];
        int[][] dis = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<Pair>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                grid[i][j] = mat[i][j];
                if(grid[i][j] == 0)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            int row = q.peek().getRow();
            int col = q.peek().getCol();
            int steps = q.peek().getSteps();
            q.poll();
            dis[row][col] = steps;

            

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol])
                        {
                       
                                q.offer(new Pair(nrow,ncol,steps+1));
                                vis[nrow][ncol] = true;
                        }
            }

           

        }

        return dis;


    }
}
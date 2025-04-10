class Pair
{
    private int dis;
    private int row;
    private int col;

    public Pair(int d,int r,int c)
    {
        this.dis = d;
        this.row = r;
        this.col = c;
    }

    public int getDis()
    {
        return dis;
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

        public int fun(int row, int col, int cnt, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol) {
            // If destination is reached
            if(row == grid.length - 1 && col == grid.length - 1) {
                return cnt;
            }
            
            // why to mark that node visited when you are reaching destination
            // anyhow you are going to backtrack 
            // so it is going to be marked as false
            vis[row][col] = true;
            int minPath = Integer.MAX_VALUE;
            
            for(int i = 0; i < 8; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid.length 
                && !vis[nrow][ncol] && grid[nrow][ncol] == 0) {
                    int pathLength = fun(nrow, ncol, cnt + 1, grid, vis, delRow, delCol);
                    if(pathLength != Integer.MAX_VALUE) {  // Only update if a valid path was found
                        minPath = Math.min(minPath, pathLength);
                    }
                }
            }
            
            vis[row][col] = false;  // Backtrack
            return minPath;
        }

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            // boolean[][] vis = new boolean[n][n];
            
            int[] delRow = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] delCol = {-1, 0, 1, -1, 1, -1, 0, 1};
            
            if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;  // Check if start or end is blocked
            
            // int ans = fun(0, 0, 1, grid, vis, delRow, delCol);
            
            // return (ans == Integer.MAX_VALUE) ? -1 : ans;

            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(1,0,0));

            int[][] dis = new int[n][n];

            for(int i = 0; i < n; i++)
            {
                Arrays.fill(dis[i],Integer.MAX_VALUE);
            }
            dis[0][0] = 1;

            while(!q.isEmpty())
            {
                Pair p = q.poll();
                int distance = p.getDis();
                int row = p.getRow();
                int col = p.getCol();

                for(int i = 0; i < 8; i++)
                {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && distance + 1 < dis[nrow][ncol])
                    {
                        dis[nrow][ncol] = distance + 1;
                        if(nrow == n - 1 && ncol == n - 1)
                        {
                            break;
                        }
                        q.offer(new Pair(dis[nrow][ncol],nrow,ncol));
                    }
                }
            }

            return dis[n-1][n-1] == Integer.MAX_VALUE ? -1 : dis[n-1][n-1];
        }
}
class Solution {

    public void dfs(int row, int col, boolean[][] vis, int[][] grid, int[] delRow, int[] delCol)
    {
        vis[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && !vis[nrow][ncol])
            {
                dfs(nrow,ncol,vis,grid,delRow,delCol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {

        // T.C -> O(N*M*4) + O(N) + O(N) ~ O(N*M)
        // S.C -> O(N-*M)
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int j = 0; j < m; j++)
        {
            if(grid[0][j] == 1 && !vis[0][j])
            {
                dfs(0,j,vis,grid,delRow,delCol);
            }

            if(grid[n-1][j] == 1 && !vis[n-1][j])
            {
                dfs(n-1,j,vis,grid,delRow,delCol);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(grid[i][0] == 1 && !vis[i][0])
            {
                dfs(i,0,vis,grid,delRow,delCol);
            }

            if(grid[i][m-1] == 1 && !vis[i][m-1])
            {

                dfs(i,m-1,vis,grid,delRow,delCol);
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!vis[i][j] && grid[i][j] == 1)
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
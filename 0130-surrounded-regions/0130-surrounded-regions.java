class Solution {

    public void dfs(int row, int col, boolean[][] visited, char[][] board, int[] delRow, int[] delCol)
    {
        visited[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && !visited[nrow][ncol])
            {
                dfs(nrow,ncol,visited,board,delRow,delCol);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        boolean[][] visited = new boolean[n][m];

        for(int j = 0; j < m; j++)
        {
            if(board[0][j] == 'O' && !visited[0][j])
            {
                dfs(0,j,visited,board,delRow,delCol);
            }

            if(board[n-1][j] == 'O' && !visited[n-1][j])
            {

                dfs(n-1,j,visited,board,delRow,delCol);
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(board[i][0] == 'O' && !visited[i][0])
            {
                dfs(i,0,visited,board,delRow,delCol);

            }

            if(board[i][m-1] == 'O' && !visited[i][m-1])
            {
                dfs(i,m-1,visited,board,delRow,delCol);

            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!visited[i][j])
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
class Solution {

    public boolean fun(int row, int col, int ind, boolean[][] vis, char[][] board, String s, int[] delrow, int[] delcol)
    {
        if(ind == s.length()) return true;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && board[nrow][ncol] == s.charAt(ind))
            {
                vis[nrow][ncol] = true;
                if(fun(nrow, ncol, ind + 1, vis, board, s, delrow, delcol)) return true;
                vis[nrow][ncol] = false;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    vis[i][j] = true;
                    if(fun(i,j,1,vis,board,word,delrow,delcol)) return true;
                    vis[i][j] = false;
                }
            }
        }

        return false;
        
    }
}
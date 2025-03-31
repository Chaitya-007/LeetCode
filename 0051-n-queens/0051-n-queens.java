class Solution {

    public boolean isSafe(int row, int col, char[][] board)
    {
        int duprow = row;
        int dupcol = col;
        int n = board.length;

        // Checking left col
        while(dupcol >= 0)
        {
            if(board[duprow][dupcol] == 'Q') return false;
            dupcol--;
        }

        dupcol = col;

        while(duprow < n && dupcol >= 0)
        {
            if(board[duprow][dupcol] == 'Q') return false;
            dupcol--;
            duprow++;

        }

         duprow = row;
         dupcol = col;

         while(duprow >= 0 && dupcol >= 0)
         {
            if(board[duprow][dupcol] == 'Q') return false;
            dupcol--;
            duprow--;

         }

         return true;
    }

    public void solve(int col, List<List<String>> ans, char[][] board, int n)
    {

        if(col == n)
        {
            List<String> solution = new ArrayList<>();

            for(char[] ch : board)
            {
                solution.add(new String(ch));
            }

            ans.add(solution);
            return;
        }


        for(int row = 0; row < n; row++)
        {
            if(isSafe(row,col,board))
            {
                board[row][col] = 'Q';
                solve(col + 1, ans, board, n);
                board[row][col] = '.';
            }
        }
    }

    public void opt(int col, List<List<String>> ans, char[][] board, int n, int[] leftrow, int[] lowerdia, int[] upprdia)
    {

        if(col == n)
        {
            List<String> solution = new ArrayList<>();

            for(char[] ch : board)
            {
                solution.add(new String(ch));
            }

            ans.add(solution);
            return;
        }


        for(int row = 0; row < n; row++)
        {
            if(leftrow[row] == 0 && lowerdia[row + col] == 0 && upprdia[n - 1 + col - row] == 0)
            {
                board[row][col] = 'Q';
                leftrow[row] = 1;
                lowerdia[row + col] = 1;
                upprdia[n - 1 + col - row] = 1;
                opt(col + 1, ans, board, n, leftrow, lowerdia, upprdia);
                board[row][col] = '.';
                leftrow[row] = 0;
                lowerdia[row + col] = 0;
                upprdia[n - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
     char[][] board = new char[n][n];

     for(int i = 0; i < n; i++)
     {
        Arrays.fill(board[i], '.');
     }   

     List<List<String>> ans = new ArrayList<>();

    //  solve(0, ans, board, n);

    int[] leftrow = new int[n];
    int[] lowerdia = new int[(2*n) - 1];
    int[] upprdia = new int[(2*n) - 1];

     opt(0, ans, board, n, leftrow, lowerdia, upprdia);

     return ans;
    }
}
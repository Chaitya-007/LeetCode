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

    public List<List<String>> solveNQueens(int n) {
     char[][] board = new char[n][n];

     

     for(int i = 0; i < n; i++)
     {
        Arrays.fill(board[i], '.');
     }   

     List<List<String>> ans = new ArrayList<>();

     solve(0, ans, board, n);

     return ans;
    }
}
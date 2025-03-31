class Solution {

    public boolean fun(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    // try out all possible conditions
                    for(char ch = '1'; ch <= '9'; ch++)
                    {

                        //  check if chosen character is safe or not
                        if(isSafe(i,j,board,ch) == true)
                        {

                        board[i][j] = ch;

                        // call the function for next empty character
                        if(fun(board) == true)
                        {
                            // if fun() returns true => then don't remove, just keep returning true;
                            return true;
                        }
                        else 
                        {
                            // if fun() returns false => then backtrack and reomve the last appended character
                            board[i][j] = '.';
                        }

                        }
                    }

                    // if you have a vaccant position but not able to fill any 0 - 9 digit
                    // return false

                    return false;

                }
            }
        }

        // once all operations are done => i.e we have solved the sudoku
        return true;
    }


    public boolean isSafe(int row, int col, char[][] board, char ch)
    {
        for(int i = 0; i < 9; i++)
        {
            if(board[row][i] == ch) return false;

            if(board[i][col] == ch) return false;

            if(board[ 3 * (row/3) + (i/3) ][ 3 * (col / 3) + (i % 3)] == ch) return false;
        }

        return true;
    }


    public void solveSudoku(char[][] board) {

        fun(board);
        
    }
}
class Pair
{
    int row;
    int col;

    public Pair(int row_, int col_)
    {
        this.row = row_;
        this.col = col_;
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
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();


        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < m; j++)
            {
               
                if(board[i][j] == 'O')
                {

                if( (i == 0 || i == n - 1) && !visited[i][j])
                {
                    visited[i][j] = true;
                    q.offer(new Pair(i,j));
                }

                if( (j == 0 || j == m - 1) && !visited[i][j] )
                {
                    visited[i][j] = true;
                    q.offer(new Pair(i,j));
                }
                }


            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty())
        {
            int row = q.peek().getRow();
            int col = q.peek().getCol();
            q.poll();

            for(int i = 0; i < 4; i++)
            {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && !visited[nrow][ncol])
                {
                    q.offer(new Pair(nrow,ncol));
                    visited[nrow][ncol] = true;
                }
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
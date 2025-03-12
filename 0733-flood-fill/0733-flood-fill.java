class Pair
{
    int row;
    int col;

    public Pair(int row_,int col_)
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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if(image[sr][sc] == color) return image;

        Queue<Pair> q = new LinkedList<>();

        // int[][] vis = new int[n][m];

        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                grid[i][j] = image[i][j];
                // vis[i][j] = -1;
            }
        }

        q.offer(new Pair(sr,sc));
        // vis[sr][sc] = color;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        int orgColor = image[sr][sc];
        grid[sr][sc] = color;

        while(!q.isEmpty())
        {
            int r = q.peek().getRow();
            int c = q.peek().getCol();
            q.poll();

            for(int i = 0; i < 4; i++)
            {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == orgColor)
                {
                    grid[nrow][ncol] = color;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }

        return grid;


    }
}
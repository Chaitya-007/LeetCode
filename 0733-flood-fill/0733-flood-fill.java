class Solution {

    public void dfs(int row,int col, int[][] image,int[][] ans, int color, int orgColor,int[] delRow,int[] delCol)
    {
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < 4; i++)
        {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == orgColor && ans[nrow][ncol] != color)
            {
                dfs(nrow,ncol,image,ans,color,orgColor,delRow,delCol);
            }
        }


    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // T.C -> O(N*M) + O(N*M*4) ~ O(N*M)
        // S.C -> O(N*M) + O(N*M) -> O(N*M)
        int n = image.length;
        int m = image[0].length;

        int[][] ans = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                ans[i][j] = image[i][j];
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        
        dfs(sr,sc,image,ans,color,image[sr][sc],delRow,delCol);

        return ans;
    }
}
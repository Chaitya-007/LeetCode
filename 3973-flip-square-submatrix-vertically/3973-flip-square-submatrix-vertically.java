class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int col = y;
        int sz = y + k - 1;

        while(col <= sz)
            {
                int l = x;
                int r = x + k - 1;
                while(l <= r)
                    {
                        int temp = grid[l][col];
                        grid[l][col] = grid[r][col];
                        grid[r][col] = temp;
                        l++;
                        r--;
                    }
                col++;
            }

        return grid;
    }
}
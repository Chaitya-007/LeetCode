class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i + k <= m && j + k <= n) {
                    int rowSize = i + k;
                    int colSize = j + k;
                    HashSet<Integer> set = new HashSet<>();
                    
                    // Collect all distinct values in the k x k submatrix
                    for(int row = i; row < rowSize; row++) {
                        for(int col = j; col < colSize; col++) {
                            set.add(grid[row][col]);
                        }
                    }
                    
                    if(set.size() == 1) {
                        list.add(0);
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        for(Integer val : set) {
                            temp.add(val);
                        }
                        
                        int sz = temp.size();
                        int ans = Integer.MAX_VALUE;
                        
                        // Find minimum absolute difference between distinct values
                        for(int x = 0; x < sz; x++) {
                            for(int y = x + 1; y < sz; y++) {
                                int var = Math.abs(temp.get(x) - temp.get(y)); // Fixed: use temp instead of list
                                ans = Math.min(ans, var);
                            }
                        }
                        list.add(ans);
                    }
                }
            }
        }
        
        // Build result matrix
        int[][] res = new int[m-k+1][n-k+1];
        int ind = 0;
        for(int i = 0; i < m-k+1; i++) {
            for(int j = 0; j < n-k+1; j++) {
                res[i][j] = list.get(ind);
                ind++;
            }
        }
        return res;
    }
}
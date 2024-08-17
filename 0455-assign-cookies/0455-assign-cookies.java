class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Strivers approach
        int m = s.length;
        int n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while(l < m && r < n)
        {
            if(s[l] >= g[r])
            {
                r++;
            }
            l++;
        }

        return r;
    }
}
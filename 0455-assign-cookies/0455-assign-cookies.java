class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;
        int m = g.length;
        int n = s.length;
        int cnt = 0;

        while(l < m && r < n)
        {
            if(s[r] >= g[l])
            {
                cnt++;
                l++;
                r++;
            }
            else
            {
                r++;
            }

        }

        return cnt;

    }
}
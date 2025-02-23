class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // T.C -> O(nlgon) + O(mlogm) + O(min(n,m))
        // S.C -> O(1)
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;
        int m = g.length;
        int n = s.length;



        while(l < m && r < n)
        {
            if(s[r] >= g[l])
            {
                l++;
            }
            r++;
           

        }

        // wherever l is standing it will be the answer

        return l;

    }
}
class Solution {

    public int minInsertions(String s) {
        String s1 = s;
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int n = s1.length();
        int m = s2.length();
        
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    curr[j] = 1 + prev[j - 1];
                }
                else
                {
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }

            // prev = curr;**** this is not going to work in java
            // ***************Very import you can swap array
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        int longest = prev[m];
        

        int ans = n - longest;
        return ans;
    }
}
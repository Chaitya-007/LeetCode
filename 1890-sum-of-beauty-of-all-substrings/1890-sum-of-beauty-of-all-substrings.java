class Solution {

    public int beautySum(String s) {
        int n = s.length();
        int maxo = 0;

        for(int i = 0; i < n; i++)
        {
            int[] freq = new int[26];
            for(int j = i; j < n; j++)
            {
             int ind = (int)(s.charAt(j) - 'a');
             freq[ind]++;

             int mx = Integer.MIN_VALUE;
             int mn = Integer.MAX_VALUE;

             for(int k = 0; k < 26; k++)
             {
                if(freq[k] > 0)
                {
                    mx = Math.max(mx,freq[k]);

                    mn = Math.min(mn, freq[k]);
                }
             }  

             maxo += mx - mn;
            }

        }

        return maxo;
    }
}
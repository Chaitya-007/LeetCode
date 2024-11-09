class Solution {
    public int maxScore(String s) {
        int zero = 0;
        int one = 0;
        int totones = 0;
        int n = s.length();
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '1')
            {
                totones++;
            }
        }

        int res = 0;

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '0')
            {
                zero++;
            }
            else
            {
                one++;
            }

            if(i != (n-1))
            {
                res = Math.max(zero - one + totones, res);
            }
        }

        return res;
    }
}
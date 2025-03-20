class Solution {

    long[][][] dp = new long[23][2][401];
    int mod = (int)(1e9 + 7);

    public long fun(int ind, int tight,int sum, int min_sum, int max_sum, String s)
    {
        if(ind == s.length())
        {
            return (min_sum <= sum && sum <= max_sum) ? 1 : 0;
        }

        if(dp[ind][tight][sum] != -1) return dp[ind][tight][sum];

        long ans = 0;

        int limit = tight == 1 ? (int)(s.charAt(ind) - '0') : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = ( tight == 1 && (d == limit) ) ? 1 : 0;

            ans += ( fun(ind + 1, newTight, sum + d, min_sum, max_sum, s) % mod ); 
        }

        return dp[ind][tight][sum] = ans;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {

        for(int i = 0; i < 23; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int sum = 0; sum < 401; sum++)
                {
                    dp[i][j][sum] = -1;
                }
            }
        }

        // 0 -> num1
        long countNum1 = fun(0,1,0,min_sum,max_sum,num1);


        for(int i = 0; i < 23; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int sum = 0; sum < 401; sum++)
                {
                    dp[i][j][sum] = -1;
                }
            }
        }

        // 0 -> num2
        long countNum2 = fun(0,1,0,min_sum,max_sum,num2);

        long sum = 0;

        for(Character ch : num1.toCharArray())
        {
             sum += (long)(ch - '0');
        }

        if(min_sum <= sum && sum <= max_sum)
        {
            countNum1 -= 1;
        } 

        return  (int)( ( (countNum2 - countNum1) % mod) + mod) % mod;
        
    }
}
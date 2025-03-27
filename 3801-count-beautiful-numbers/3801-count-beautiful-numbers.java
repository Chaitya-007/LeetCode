class Solution {

    HashMap<String, Long> dp;

    public String getState(int ind, int newTight, long sum, long product, int validnum)
    {
        String str = String.valueOf(ind) + "." + String.valueOf(newTight) + "." + String.valueOf(sum) + "." + String.valueOf(product) + "." +  String.valueOf(validnum);
        return str;
    }

    public long fun(int ind, int tight, long sum, long product, int validnum, String str)
    {

        if(ind == str.length())
        {
            if(sum == 0) return 0;
            return product%sum == 0 ? 1 : 0;
        }

        String state = getState(ind,tight,sum,product,validnum);

        if(dp.containsKey(state)) return dp.get(state);

        long ans = 0;

        int limit = tight == 1 ? str.charAt(ind) - '0' : 9;

        for(int d = 0; d <= limit; d++)
        {
            int newTight = (tight == 1 && (d == limit)) ? 1 : 0;

            if(validnum == 0 && d == 0)
            {
            
                ans += fun(ind + 1, newTight, 0, 1, 0, str);

            }
            else if(validnum == 0 && d > 0)
            {
                
                ans += fun(ind + 1, newTight, sum + (long)d, product * (long)d, 1, str);
            }
            else 
            {
                
                ans += fun(ind + 1, newTight, sum + d, product * d, validnum, str);
                

            }

            
        }

        dp.put(state, ans);
        return ans;

    }

    public int beautifulNumbers(int l, int r) {
        String low = String.valueOf(l - 1);

        dp = new HashMap<>();

        long cntNum1 = fun(0,1,0,1,0,low);



        String high = String.valueOf(r );
        dp = new HashMap<>();

        long cntNum2 = fun(0,1,0,1,0,high);

        return (int)(cntNum2 - cntNum1);
    }
}
class Solution {
    public double myPow(double x, int n) {

        if(n == Integer.MIN_VALUE)
        {
            x = x*x;
            n = n/2;
        }

        int m = n;

        double ans = 1;



        if(n < 0)
        {
            n = -n;
        }

        while(n > 0)
        {
            if((n&1) == 0)
            {
                x = x * x;
                n = n / 2;
            }
            else
            {
                ans = ans * x;
                n = n - 1;
            }
        }

        if(m < 0) ans = 1.0/ans;

        return ans;
    }
}
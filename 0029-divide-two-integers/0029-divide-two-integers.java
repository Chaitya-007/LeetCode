class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        // If dividend is Integer.MIN_VALUE then you cannot take their absolute 

        if(dividend == Integer.MIN_VALUE && divisor == -1)
        {
            return Integer.MAX_VALUE;
        }

        if(dividend == Integer.MIN_VALUE && divisor == 1)
        {
            return Integer.MIN_VALUE;
        }

        long dd = Math.abs((long)dividend);
        long ds = Math.abs((long)divisor);
        int q = 0;

        boolean sign = (dividend >= 0) == (divisor > 0);

        while(dd >= ds)
        {
            int cnt = 0;
            while(dd >= (ds<<(cnt + 1)))
            {
                cnt++;
            }

            dd -= (ds<<cnt);
            q += (1<<cnt);
        }

        return sign ? q : -q;


        
    }
}
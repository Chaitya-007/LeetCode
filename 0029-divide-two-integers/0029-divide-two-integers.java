class Solution {
    public int divide(int dividend, int divisor) {
     if(dividend == Integer.MIN_VALUE && divisor == -1)
     {
        return Integer.MAX_VALUE;
     }

     if(dividend == Integer. MIN_VALUE && divisor == 1)
     {
        return Integer.MIN_VALUE;
     }

     boolean sign = (dividend >= 0) == (divisor > 0);

     long n = Math.abs((long)dividend);
     long d = Math.abs((long)divisor);

     long quotient = 0;

     while(n >= d)
     {
        long cnt = 0;

        while(n >= (d<<(cnt + 1)))
        {
            cnt++;
        }

        quotient += (1<<cnt);

        n = n - (d<<cnt);
     } 

     return sign ? (int)quotient : (int)(-1*quotient);

    }
}
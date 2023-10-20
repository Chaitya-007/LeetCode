class Solution {
public:
    int reverse(int x) {

        // bool negative = false;
        // long long temp = abs(x);
        // long long rev = 0;
        // int rem = 0;
        // if(x<0)
        // {
        //     negative = true;
        // }

        // while(temp) // this works for both positive and
        // {
        //     rem = temp%10;
        //     temp = temp/10;
        //     rev = rem + rev*10;
        // }

        // if(negative)
        // {
        //     rev = (-1)*rev;
        // }

        // if(rev < INT_MIN || rev > INT_MAX)
        // {
        //     return 0;
        // }

        // return rev;

      //************************************************** 
        // int result = 0;

        // while(x != 0)
        // {
        //     int rem = x%10;
        //     int newresult = result*10 + rem; => gets overflowed
        //     if(newresult/10 != result)
        //     {
        //         return 0;
        //     }
        //     result = newresult;
        //     x = x/10;
        // }

        // return result;
        
        int result = 0;
        while(x)
        {
            int rem = x%10;
            if ( (INT_MAX/10 < result || (INT_MAX/10 == result and  INT_MAX%10< rem)) || (INT_MIN/10 > result )|| (INT_MIN/10 == result and INT_MIN%10 > rem) )
            {
                return 0;
            }

            result = rem + (result*10);
            x = x/10;
        }
        return result;
    }
};
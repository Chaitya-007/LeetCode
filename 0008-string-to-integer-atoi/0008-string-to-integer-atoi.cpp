class Solution {
public:
    int myAtoi(string s) {

        int n = s.length();
        int i = 0;

        while(i < n and s[i] == ' ')
        {
            i++;
        }

        int sign = 1;
        if(i < n and ( (s[i] == '+') or (s[i] == '-') ) )
        {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }

        int result = 0;
        while(i < n and ('0' <= s[i] and s[i] <= '9'))
        {
            int digit = (s[i] - '0');

            //  if (result > (INT_MAX - digit) / 10) // tHIS WAS GIVEN BY GOOGLE BARD
            if( (result > (INT_MAX/10)) || ( (result == (INT_MAX/10)) and (digit >(INT_MAX%10)) ) )
            {
                return (sign == 1) ? INT_MAX : INT_MIN;
            } 

            result = digit + result*10;
            i++;
        }

        return sign*result;
    }
};
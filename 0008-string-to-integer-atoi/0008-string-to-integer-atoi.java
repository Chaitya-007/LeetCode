class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

      

        while(i < n && s.charAt(i) == ' ')
        {
            i++;
        }

        if(i == n)
        {
            return 0;
        }

        char sign = '+';

       
            if(s.charAt(i) == '+')
            {
                sign = '+';
                i++;
            }
            else if(s.charAt(i) == '-')
            {
                sign = '-';
                i++;
            }
            else if(!Character.isDigit(s.charAt(i)))
            {
                return 0;
            }

            while(i < n && s.charAt(i) == '0')
            {
                i++;
            }

            int num = 0;

            while(i < n && Character.isDigit(s.charAt(i)))
            {
                int val = (int)(s.charAt(i) - '0');

                if(num > (Integer.MAX_VALUE/10) ||  ( ( num == (Integer.MAX_VALUE/10) ) && (val > (Integer.MAX_VALUE%10)) ) )
                {
                    return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = (num*10) + val;
                i++;
            }

            return sign == '+' ? num : (-1*num);
        
        
    }
}
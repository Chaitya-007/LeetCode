class Solution {

    // BigInteger toNum(String temp)
    // {
    //     BigInteger num = 0;
    //     for(int i = 0; i < temp.length(); i++)
    //     {
    //         num = (temp.charAt(i) - '0') + num*10;
    //     }

    //     return num;
    // }
    public String largestOddNumber(String num) {
        
        int n = num.length();

        int i = 0;
        for(i = 0; i < n; i++)
        {
            if(num.charAt(i) != '0')
            {
                break;
            }
        }
        int start = i;
        String temp = "";

        for(; i < n; i++)
        {
            int digit = (num.charAt(i) - '0');
            if(digit%2 == 1)
            {
                 temp = num.substring(start,i+1);
            }
        }

        // while(maxo > 0)
        // {
        //     BigInteger rem = maxo%10;
        //     char ch = (char)(rem + '0');
        //     result = ch + result;
        //     maxo = maxo/10;
        // }

        return temp;

    }
}
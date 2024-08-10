class Solution {
    public String largestOddNumber(String num) {
        
        int n = num.length();

       
        // does not contain any leading zeroes => written in constraints
        // for(i = 0; i < n; i++)
        // {
        //     if(num.charAt(i) != '0')
        //     {
        //         break;
        //     }
        // }

       

        String temp = "";

        for(int i = 0; i < n; i++)
        {
            int digit = (num.charAt(i) - '0');
            if(digit%2 == 1)
            {
                 temp = num.substring(0,i+1);
            }
        }

        return temp;

    }
}
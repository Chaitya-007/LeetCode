class Solution {

    public boolean to_base(int num,int base)
    {
        StringBuilder sb = new StringBuilder("");

        while(num != 0)
        {
            int rem = (num%base);
            sb.append((char)(rem + '0'));
            num = num/base;
        }

        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        if(str1.equals(str2))
        {
            return true;
        }

        return false;
    }


    public boolean isStrictlyPalindromic(int n) {
        
        for(int i = 2; i <= n - 2; i++)
        {
            if(to_base(n,i))
            {

            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
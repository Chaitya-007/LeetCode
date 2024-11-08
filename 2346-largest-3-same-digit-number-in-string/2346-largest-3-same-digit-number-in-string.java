class Solution {
    public String largestGoodInteger(String num) {
        int p = 0;
        int q = 1;
        int r = 2;
        int maxo = -1;
        int n = num.length();

        while(r < n)
        {
            char ch1 = num.charAt(p);
            char ch2 = num.charAt(q);
            char ch3 = num.charAt(r);

            if(ch1 == ch2 && ch2 == ch3)
            {
                String temp = num.substring(p,r+1);
                int val = Integer.valueOf(temp);
                if(maxo < val)
                {
                    maxo = val;
                }
            }

            p++;
            q++;
            r++;
        }

        if(maxo == -1)
        {
            return "";
        }

        if(maxo == 0)
        {
            return "000";
        }

        String str = String.valueOf(maxo);
        return str;
    }
}
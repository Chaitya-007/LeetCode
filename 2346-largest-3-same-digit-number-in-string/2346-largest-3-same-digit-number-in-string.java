class Solution {
    public String largestGoodInteger(String num) {

        int p = 0;
        int q = 1;
        int r = 2;
        int n = num.length();
        int maxo = -1;

        while(r < n)
        {
            char cha = num.charAt(p);
            char chb = num.charAt(q);
            char chc = num.charAt(r);
            if(cha == chb && chb == chc)
            {
                String str = num.substring(p,r+1);
                int number = Integer.valueOf(str);
                maxo = Math.max(maxo,number);
            }
            p++;
            q++;
            r++;
        }

        if(maxo == 0)
        {
            return "000";
        }

        if(maxo == -1)
        {
            return "";
        }

        String str = String.valueOf(maxo);

        return str;
        
    }
}
class Solution {
    public String largestGoodInteger(String num) {

        int res = -1;
        int n = num.length();

        for(int i = 0; i <= (n - 3); i++)
        {
            String str = num.substring(i, Math.min(i+3,n));

            char p = str.charAt(0);
            char q = str.charAt(1);
            char r = str.charAt(2);

            if(p == q && q == r)
            {
                int val = ( (int)(p - '0')*100 ) + ((int)(q-'0')*10) + (int)(r-'0');
                res = Math.max(res,val); 
            }
        }

        if(res == 0)
        {
            return "000";
        }
        else if(res == -1)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder("");
        while(res > 0)
        {
            int rem = res%10;
            res = res/10;
            sb.append((char)(rem + '0'));
        }

        return sb.toString();
        
    }
}
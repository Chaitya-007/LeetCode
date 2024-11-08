class Solution {

    public static int convert(String str, int l, int r)
    {
        int num = 0;
        for(int i = l; i <= r; i++)
        {
            char ch = str.charAt(i);
            int val = (int)(ch - '0');
            num = val + (num*10);
        }

        return num;
    }


    public String largestGoodInteger(String num) {
        int l = 0;
        int r = 1;
        int n = num.length();
        int maxo = -1;

        while(l < n && r < n)
        {
            if(num.charAt(l) != num.charAt(r))
            {
                l++;
                r++;
            }
            else
            {
                while(l < n && r < n)
                {
                    if((r - l) == 2 && num.charAt(l) == num.charAt(r))
                    {
                        int val = convert(num, l, r);
                        if(maxo < val)
                        {
                            maxo = val;
                        }
                        l = r + 1;
                        r = l + 1;
                        break;
                    }

                    if(num.charAt(l) == num.charAt(r))
                    {
                        r++;
                    }
                    else
                    {
                        l++;
                        break;
                    }
                }
            }
        }

        if(maxo == -1)
        {
            return "";
        }

        if(maxo == 0)
        {
            return "000";
        }

        String str = "";
        while(maxo > 0)
        {
            int rem = maxo%10;
            maxo = maxo/10;
            char ch = (char)(rem + '0');
            str += ch;
        }

        return str;
    }
}
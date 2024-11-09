class Solution {

    public static String digStr(String str)
    {
        int sum = 0;
        for(int i = 0; i < str.length(); i++)
        {
            int num = (int)(str.charAt(i) - '0');
            sum += num;
        }

        if(sum == 0)
        {
            return "0";
        }

        StringBuilder sb = new StringBuilder("");
        while(sum > 0)
        {
            int rem = sum%10;
            sum = sum/10;
            char ch = (char) (rem + '0');
            sb.append(ch);
        }

        return sb.reverse().toString();
    }

    public String digitSum(String s, int k) {
        while(s.length() > k)
        {
            StringBuilder sb = new StringBuilder("");

            for(int i = 0; i < s.length(); i = i + k)
            {
                String str = s.substring(i, Math.min(s.length(), i + k));
                String dig = digStr(str);
                sb.append(dig);
            }

            s = sb.toString();
        }

        return s;
    }
}
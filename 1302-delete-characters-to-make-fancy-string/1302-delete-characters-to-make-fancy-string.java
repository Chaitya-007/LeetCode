class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder("");
         str.append(s.charAt(0));
        int cnt = 1;
        int n = s.length();

        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == s.charAt(i - 1))
            {
                cnt++;
                if(cnt < 3)
                {
                    str.append(s.charAt(i));
                }
            }
            else
            {
                cnt = 1;
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
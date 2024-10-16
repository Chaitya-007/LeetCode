class Solution {
    public String removeStars(String s) {
        int n = s.length();
        int i = n - 1;
        String str = "";
        int cnt = 0;
        while(i >= 0)
        {
            if(s.charAt(i) == '*')
            {
                cnt++;
            }
            else
            {
                if(cnt > 0)
                {
                    cnt--;
                }
                else
                {
                    str = s.charAt(i) + str;
                }
                
            }
            i--;
        }

        return str;
    }
}
class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        int n = s.length();
        String str = "";

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '(')
            {
                
                cnt++;
                if(cnt != 1)
                {
                    str += '(';
                }
            }
            else
            {
                if(cnt != 1)
                {
                    str += ')';
                }
                cnt--;
               
            }

        }
        return str;
    }
}
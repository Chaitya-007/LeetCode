class Solution {
    public String removeOuterParentheses(String s) {

     int cnt = 0;

     int n = s.length();

     StringBuilder sb = new StringBuilder("");

     for(int i = 0; i < n; i++)
     {
        char ch = s.charAt(i);

        if(ch == '(')
        {
            cnt++;

            if(cnt > 1)
            {
                sb.append(ch);
            }
        }
        else
        {
            if(cnt > 1)
            {
                sb.append(ch);
            }
            cnt--;
        }
     }

     return sb.toString();

    }
}
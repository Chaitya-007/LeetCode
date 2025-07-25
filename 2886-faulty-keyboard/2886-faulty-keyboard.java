class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder("");

        int n = s.length();

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);

            if(ch == 'i')
            {
                sb = new StringBuilder(sb.reverse().toString());
            }
            else
            {
            sb.append(ch);

            }
        }

        return sb.toString();
    }
}
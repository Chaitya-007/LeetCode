class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
        {
            return false;
        }

        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < n; i++)
        {
            if(sb.toString().equals(goal))
            {
                return true;
            }
            else
            {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
            }
        }

        return false;
    }
}
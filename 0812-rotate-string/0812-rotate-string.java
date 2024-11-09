class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() == goal.length())
        {
            String newStr = (s + s);
            if(newStr.contains(goal))
            {
                return true;
            }
            return false;
        }
        return false;
    }
}
class Solution {
    public boolean rotateString(String s, String goal) {

     if(s.length() != goal.length())
     {
        return false;
     }   

     String str = goal + goal;

     if(str.contains(s))
     {
        return true;
     }

     return false;

    }
}
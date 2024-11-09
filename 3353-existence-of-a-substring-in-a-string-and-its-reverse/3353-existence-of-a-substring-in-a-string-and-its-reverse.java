class Solution {
    public boolean isSubstringPresent(String s) {
     StringBuilder sb = new StringBuilder(s);
     String rev = sb.reverse().toString();

     int n = s.length();

     for(int i = 0; i < n; i++)
     {
        String str = s.substring(i, Math.min(n, i + 2));

        if(str.length() == 2 && rev.indexOf(str) >= 0)
        {
            return true;
        }
     }   

     return false;


    }
}
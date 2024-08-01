class Solution {
    public boolean isSubstringPresent(String s) {

        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        

        for(int i = 0; i < s.length(); i++)
        {
            String t = s.substring(i,Math.min(i+2,s.length()));

            if(t.length() == 2 && sb.indexOf(t) >= 0)
            {
                // System.out.println(t);
                return true;
            }
        }

        return false;

    }
}
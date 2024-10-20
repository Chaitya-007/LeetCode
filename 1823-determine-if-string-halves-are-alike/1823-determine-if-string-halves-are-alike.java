class Solution {
    public boolean halvesAreAlike(String s) {
        // String left = s.substring(0,(s.length())/2).toLowerCase();
        // String right = s.substring(s.length()/2,s.length()).toLowerCase();
        // System.out.println(left);

        int leftcnt = 0;
        int rightcnt = 0;

        String vowel = "aeiouAEIOU"; // can also use HashSet and contains method

        for(int i = 0; i < s.length(); i++)
        {
            if(i < s.length()/2)
            {
                if(vowel.indexOf(s.charAt(i)) >= 0)
                {
                    leftcnt++;
                }
            }
            else
            {
                if(vowel.indexOf(s.charAt(i)) >= 0)
                {
                    rightcnt++;
                }
            }
        }

        if(leftcnt == rightcnt)
        {
            return true;
        }

        return false;
    }
}
class Solution {
    public String longestPalindrome(String s) {

        if(s.length() <= 1)
        {
            return s;
        }


        String lps = "";

        int n = s.length();

        // start from i = 1 => is most important
        for(int i = 1; i < n; i++)
        {
            // Check for odd length palidrome
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;

                if(low == -1 || high == s.length())
                {
                    break;
                }
            }

            String palin = s.substring(low+1,high);
            if(palin.length() > lps.length())
            {
                lps = palin;
            }

            // Check for even length palindrome
            low = i - 1;
            high = i;

            while(s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;

                if(low == -1 || high == s.length())
                {
                    break;
                }
            }

            palin = s.substring(low+1,high);
            if(palin.length() > lps.length())
            {
                lps = palin;
            }
        }

        return lps;

    }
}
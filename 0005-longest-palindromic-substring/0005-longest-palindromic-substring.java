class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
        {
            return s;
        }

        int n = s.length();
        StringBuilder lps = new StringBuilder("");

        for(int i = 1; i < n; i++)
        {
            // Odd length palindrome
            int left = i;
            int right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;

                if(left == -1 || right == n)
                {
                    break;
                }
            }

            StringBuilder palin = new StringBuilder(s.substring(left + 1, right));
            if(palin.length() > lps.length())
            {
                lps = new StringBuilder(palin.toString());
            }

            left = i - 1;
            right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;

                if(left == -1 || right == n)
                {
                    break;
                }
            }

            palin = new StringBuilder(s.substring(left + 1, right));
            if(palin.length() > lps.length())
            {
                lps = new StringBuilder(palin.toString());
            }
        }

        return lps.toString();
    }
}
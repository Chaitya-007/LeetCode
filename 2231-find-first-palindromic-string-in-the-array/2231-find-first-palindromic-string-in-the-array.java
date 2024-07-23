class Solution {

    public static boolean checkPalindrome(String str)
    {
        int l = 0;
        int r = str.length() - 1;

        while(l < r)
        {
            if(str.charAt(l) != str.charAt(r))
            {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public String firstPalindrome(String[] words) {
        
        for(int i = 0; i < words.length; i++)
        {
            if(checkPalindrome(words[i]))
            {
                return words[i];
            }
        }

        return "";
    }
}
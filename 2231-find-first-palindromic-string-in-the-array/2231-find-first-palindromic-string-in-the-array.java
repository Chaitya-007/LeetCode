class Solution {

    public static boolean checkPalindrome(String str)
    {
        // M 1
        // int l = 0;
        // int r = str.length() - 1;

        // while(l < r)
        // {
        //     if(str.charAt(l) != str.charAt(r))
        //     {
        //         return false;
        //     }

        //     l++;
        //     r--;
        // }

        // return true;

        // M2
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String newstr = sb.toString();
        if(newstr.equals(str))
        {
            return true;
        }

        return false;
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
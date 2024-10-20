class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String str_first = "";
        String str_second = "";

        for(int i = 0; i < word1.length; i++) // use .length for arrays => not .length() => because .length is a property not method
        {
           str_first = str_first.concat(word1[i]); // while using concat() we have to assign it to string again
        }

        for(int i = 0; i < word2.length; i++)
        {
            str_second += word2[i]; // this way is also allowed
        }

        if(str_first.equals(str_second))
        {
            return true;
        }

        return false;
    }
}
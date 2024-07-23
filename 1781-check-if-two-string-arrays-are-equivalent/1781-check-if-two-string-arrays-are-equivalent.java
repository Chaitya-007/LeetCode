class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String str_first = "";
        String str_second = "";

        for(int i = 0; i < word1.length; i++)
        {
            str_first += word1[i];
        }

        for(int i = 0; i < word2.length; i++)
        {
            str_second += word2[i];
        }

        if(str_first.equals(str_second))
        {
            return true;
        }

        return false;
    }
}
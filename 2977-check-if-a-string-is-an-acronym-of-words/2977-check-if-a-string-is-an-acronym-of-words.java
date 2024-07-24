class Solution {
    public boolean isAcronym(List<String> words, String s) {
        
        int n = s.length();
        int list_size = words.size();

        if(n != list_size)
        {
            return false;
        }

        
            for(int i = 0; i < n; i++)
            {
                if(words.get(i).charAt(0) != s.charAt(i))
                {
                    return false;
                }
            }

            return true;
    }
}
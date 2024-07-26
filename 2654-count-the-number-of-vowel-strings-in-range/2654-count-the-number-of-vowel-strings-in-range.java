class Solution {
    public int vowelStrings(String[] words, int left, int right) {

        String str = "aeiou";
        int cnt = 0;
        
        for(int i = left; i <= right; i++)
        {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            
            if(str.indexOf(start) >= 0 && str.indexOf(end) >= 0)
            {
                cnt++;
            }
        }

        return cnt;
    }
}
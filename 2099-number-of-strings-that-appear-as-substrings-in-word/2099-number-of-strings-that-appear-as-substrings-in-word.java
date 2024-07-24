class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        int cnt = 0;
        for(String str : patterns)
        {
            // if(word.contains(str))
            if(word.indexOf(str) >= 0)
            {
                cnt++;
            }
        }

        return cnt;
    }
}
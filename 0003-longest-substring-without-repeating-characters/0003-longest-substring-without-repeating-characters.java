class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxlen = 0;
        int n = s.length();

        for(int i = 0; i < n; i++)
        {
            // HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            HashSet<Character> set = new HashSet<>();

            for(int j = i;  j < n; j++)
            {
                if(set.contains(s.charAt(j)) )
                {
                    break;
                }
                else
                {
                    set.add(s.charAt(j));
                    maxlen = Math.max(maxlen,set.size());
                }
            }

        }
            return maxlen;
        
    }
}
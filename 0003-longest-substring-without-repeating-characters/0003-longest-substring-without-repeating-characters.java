class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int cnt = 0;
        int maxLen = 0;
        int l = 0;
        int r = n - 1;

        for(int i = 0; i < n; i++)
        {
        HashSet<Character> set = new HashSet<Character>();

            for(int j = i; j < n; j++)
            {
            char ch = s.charAt(j);

            if(set.contains(ch))
            {
                break;
            }
            else
            {
                set.add(ch);
            }

            }

            int size = set.size();

            maxLen = Math.max(maxLen,size);
        }

        return maxLen;
    }
}
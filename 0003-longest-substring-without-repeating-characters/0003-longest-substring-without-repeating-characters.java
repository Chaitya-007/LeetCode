class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int n = s.length();
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        int maxLen = 0;

        while(r < n)
        {
            if(hmap.containsKey(s.charAt(r)))
            {
                if(hmap.get(s.charAt(r)) >= l)
                {
                    l = 1 + (hmap.get(s.charAt(r)));
                }
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen,len);

            hmap.put(s.charAt(r),r);
            r++;
        }

        return maxLen;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int n = s.length();
        int maxlen = 0;
        int l = 0;
        int r = 0;

        while(r < n)
        {
            if(map.containsKey(s.charAt(r)))
            {
                if(map.get(s.charAt(r)) >= l)
                {
                    l = map.get(s.charAt(r)) + 1;
                }
            }

            map.put(s.charAt(r), r);

            int len = r - l + 1;
            maxlen = Math.max(maxlen,len);
            r++;
        }

        return maxlen;
    }
}
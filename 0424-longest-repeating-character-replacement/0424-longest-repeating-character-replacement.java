class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        int maxlen = 0;

        while(r < n)
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));

            int len = r - l + 1;

            int changes = len - maxfreq;

            while(changes > k)
            {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);

                if(map.get(s.charAt(l)) == 0)
                {
                    map.remove(s.charAt(l));
                }

                maxfreq = 0;
                for(Integer val : map.values())
                {

                maxfreq = Math.max(maxfreq, val);

                }

                l++;

                changes = (r - l + 1) - maxfreq;
            }

            len = r - l + 1;

            maxlen = Math.max(maxlen, len);
            r++;
        }

        return maxlen;
    }
}
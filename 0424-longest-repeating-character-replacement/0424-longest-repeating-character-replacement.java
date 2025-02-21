class Solution {
    public int characterReplacement(String s, int k) {
        

        // T.C -> (O(N)) => there was no point in trimming down the length, because it is not giving to contribute to maxlen 
        // S.C -> O(26) -> O(1)
        
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        int maxlen = 0;

        while(r < n) // O(N)
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));

            int len = r - l + 1;

            int changes = len - maxfreq;

            if(r - l + 1 - maxfreq > k)
            {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);

                if(map.get(s.charAt(l)) == 0)
                {
                    map.remove(s.charAt(l));
                }

                l++;
               
            }

            len = r - l + 1;

            maxlen = Math.max(maxlen, len);
            r++;
        }

        return maxlen;
    }
}
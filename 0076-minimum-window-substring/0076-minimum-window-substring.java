class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int minlen = Integer.MAX_VALUE;
        int startInd = -1;

        for(char ch : t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        while(r < n)
        {
            int freq = map.getOrDefault(s.charAt(r), 0);
            if(freq > 0)
            {
                ans++;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) - 1);

            while(ans == m)
            {
                if(minlen > r - l + 1)
                {
                    minlen = r - l + 1;
                    startInd = l;
                }
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                if(map.get(s.charAt(l)) > 0)
                {
                    ans--;
                }
                l++;
            }

            r++;
        }

        return startInd == -1 ? "" : s.substring(startInd, Math.min(startInd + minlen, n ));

    }
}
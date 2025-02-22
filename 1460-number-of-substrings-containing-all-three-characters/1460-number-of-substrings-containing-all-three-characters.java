class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        while(r < n)
        {
            map.put(s.charAt(r), r);

            if(map.size() == 3)
            {
                int lastSeen = n;
                for(Integer val : map.values())
                {
                    lastSeen = Math.min(lastSeen,val);
                }
                ans += (lastSeen + 1);
            }

            r++;
        }

        return ans;
        
    }
}
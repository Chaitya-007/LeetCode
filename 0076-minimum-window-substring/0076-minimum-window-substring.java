class Solution {
    public String minWindow(String s, String t) {
     int l = 0;
     int r = 0;
     int n = s.length();
     int m = t.length();

     HashMap<Character, Integer> map = new HashMap<Character,Integer>();
     for(char ch : t.toCharArray())
     {
        map.put(ch, map.getOrDefault(ch,0) + 1);
     }
     int cnt = 0;
     int minLen = Integer.MAX_VALUE;
     int startInd = -1;

        while(r < n)
        {
            int freq = map.getOrDefault(s.charAt(r),0);
            if(freq > 0)
            {
                cnt++;
            }

            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0) - 1);

            if(cnt == m)
            {
                while(cnt == m)
                {
                    if((r - l + 1) < minLen)
                    {
                        minLen = (r - l + 1);
                        startInd = l;
                    }

                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1 );

                    if(map.get(s.charAt(l)) > 0)
                    {
                        cnt--;
                    }

                    l++;
                }
            }

            r++;
        }

        return startInd == -1 ? "" : s.substring(startInd, Math.min(n, startInd + minLen));

    }
}
class Solution {
    public int numberOfSubstrings(String s) {

        int l = 0;
        int r = 0;
        int n = s.length();


        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int cnt = 0;
        

        while(r < n)
        {
            char ch = s.charAt(r);
            map.put(ch, r);

            if(map.size() == 3)
            {
                int minInd = n;

                for(Integer val : map.values())
                {
                    if(minInd > val)
                    {
                        minInd = val;
                    }
                }

                cnt += (minInd + 1);
            }

            r++;
        }

        return cnt;

    }
}
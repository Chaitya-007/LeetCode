class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxf = 0;
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        int maxLen = 0;


        while(r < n)
        {
            hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r),0) + 1);

            maxf = Math.max(maxf,hmap.get(s.charAt(r)));

            int len = r - l + 1;
            if((len - maxf) <= k)
            {
                maxLen = Math.max(maxLen,len);
            }
            else
            {

                if(((r - l + 1) - maxf) > k)
                {
                    hmap.put(s.charAt(l), hmap.get(s.charAt(l)) - 1);
                     
                    // maxf =  0;

                    if(hmap.get(s.charAt(l)) == 0)
                    {
                        hmap.remove(s.charAt(l));
                    }

                    // for(Integer val : hmap.values())
                    // {
                    //     maxf = Math.max(maxf,val);
                    // }

                    l++;

                }

                maxLen = Math.max(maxLen,(r - l + 1));
            }

            r++;
        }

        return maxLen;

    }
}
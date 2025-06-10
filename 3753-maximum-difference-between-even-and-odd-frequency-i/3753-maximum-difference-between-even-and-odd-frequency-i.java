class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();

        for(char ch : s.toCharArray())
        {
            hmap.put(ch,hmap.getOrDefault(ch,0) + 1);
        }

        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;

        for(Integer val : hmap.values())
        {
            if(val%2 != 0)
            {
                odd = Math.max(odd,val);
            }
            else
            {
                even = Math.min(even,val);
            }
        }

        return odd - even;
    }
}
class Solution {

    public int getAns(HashMap<Character, Integer> map, int k)
    {
        int res = 0;

        {
            int mn = Math.min(map.get('N'),map.get('S'));
            int mx = Math.max(map.get('N'),map.get('S'));

            int del = Math.min(mn,k);
            mn -= del;
            mx += del;
            k -= del;
            res += (mx - mn);
        }
        {
            int mn = Math.min(map.get('E'),map.get('W'));
            int mx = Math.max(map.get('E'),map.get('W'));

            int del = Math.min(mn,k);
            mn -= del;
            mx += del;
            k -= del;
            res += (mx - mn);
        }

        return res;

    }

    public int maxDistance(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('N',0);
        map.put('E',0);
        map.put('S',0);
        map.put('W',0);

        int ans = 0;

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
            ans = Math.max(getAns(map,k),ans);
        }

        return ans;
        
    }
}
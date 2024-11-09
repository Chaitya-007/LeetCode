class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int n = words.length;

        for(int i = 0; i < n; i++)
        {
            String str = words[i];

            for(int j = 0; j < str.length(); j++)
            {
                char ch = str.charAt(j);
                if(map.containsKey(ch))
                {
                    map.put(ch, map.get(ch) + 1);
                }
                else
                {
                    map.put(ch, 1);
                }
            }
        }

        for(Integer i : map.values())
        {
            if(i%n != 0)
            {
                return false;
            }
        }

        return true;
    }
}
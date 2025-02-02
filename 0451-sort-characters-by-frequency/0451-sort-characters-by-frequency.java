class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int n = s.length();

        List<List<Character>> list = new ArrayList<>(n+1);

        for(int i = 0; i <= n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            int ind = e.getValue();
            list.get(ind).add(e.getKey());
        }

        StringBuilder sb = new StringBuilder("");

        for(int i = n ; i >= 0; i--)
        {
            if(list.get(i).size() != 0)
            {
                for(Character ch : list.get(i))
                {
                for(int k = 1; k <= i; k++)
                {
                    sb.append(ch);
                }

                }
            }
        }

        return sb.toString();


    }
}
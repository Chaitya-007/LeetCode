class Solution {
    public String frequencySort(String s) {
        // Bucket Sorting

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        List<List<Character>> list = new ArrayList<>();

        for(int i = 0; i < (s.length() + 1); i++)
        {
            list.add(new ArrayList<>());
        }

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            list.get(e.getValue()).add(e.getKey());
        }

        StringBuilder sb = new StringBuilder("");

        for(int i = (s.length()) ; i >= 0; i--)
        {
            if(list.get(i).size() != 0)
            {
                for(Character ch : list.get(i))
                {
                    for(int j = 1; j <= i; j++)
                    {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();

       
    }
}
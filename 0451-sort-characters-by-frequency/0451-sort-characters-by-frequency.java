class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        Map<Integer, List<Character> > freq = new TreeMap<Integer, List<Character> >(Collections.reverseOrder());

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            int key = e.getValue();
            char val = e.getKey();

            if(freq.containsKey(key))
            {
                List<Character> list = freq.get(key);
                list.add(val);
                freq.put(key,list);
            }
            else
            {
                List<Character> list = new ArrayList<Character>();
                list.add(val);
                freq.put(key,list);
            }
        }

        StringBuilder sb = new StringBuilder("");

        for(Map.Entry<Integer, List<Character> > e : freq.entrySet())
        {
            int key = e.getKey();
            List<Character> list = e.getValue();

            for(Character ch : list)
            {

            for(int i = 1; i <= key; i++)
            {
                sb.append(ch);
            }

            }
        }

        return sb.toString();
    }
}
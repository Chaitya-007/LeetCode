class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        Map<Integer, List<Character> > listMap = new TreeMap<Integer, List<Character> >();

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            int key = e.getValue();

            if(listMap.containsKey(key))
            {

                List<Character> list = listMap.get(key);
                list.add(e.getKey());
                listMap.put(key, list);
            }
            else
            {
                
                // map.put(e.getValue(), list);
                
                List<Character> list = new ArrayList<Character>();
                list.add(e.getKey());
                listMap.put(key,list);
            }
        }

        StringBuilder sb = new StringBuilder("");

        for(Map.Entry<Integer, List<Character> > e : listMap.entrySet())
        {
            for(Character ch : e.getValue())
            {

            for(int i = 1; i <= e.getKey(); i++)
            {
                sb.append(ch);
            }

            }

        }

        return sb.reverse().toString();

    }
}
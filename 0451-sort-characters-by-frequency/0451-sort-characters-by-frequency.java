class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        List<Pair<Character, Integer>> list = new ArrayList<Pair<Character, Integer>>();

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            // Pair<Character, Integer> p = new Pair<Character, Integer>(e.getKey(), e.getValue());
            // list.add(p);
            list.add(new Pair<>(e.getKey(),e.getValue()));
        }

        Comparator<Pair<Character, Integer>> comparator = (p1,p2) -> 
        {
            return p2.getValue().compareTo(p1.getValue());
        };

        Collections.sort(list,comparator);

        // System.out.println(list);
        StringBuilder sb = new StringBuilder("");

        for(Pair<Character, Integer> p : list)
        {
            for(int i = 1; i <= p.getValue(); i++)
            {
                sb.append(p.getKey());
            }
        }

        return sb.toString();

        
    }
}
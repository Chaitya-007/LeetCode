class Solution {
    public String oddString(String[] words) {
        Map<List<Integer>, List<String> > map = new HashMap<List<Integer>, List<String> >();

        for(int i = 0; i < words.length; i++)
        {
            String str = words[i];
            List<Integer> list = new ArrayList<Integer> ();

            for(int j = 1; j < str.length(); j++)
            {
                int val = (int)(str.charAt(j) - str.charAt(j-1));
                list.add(val);
            }

            if(map.containsKey(list))
            {
                map.get(list).add(str);
            }
            else
            {
                List<String> l = new ArrayList<String>();
                l.add(str);
                map.put(list,l);
            }
        }

        for(List<Integer> list : map.keySet())
        {
            if(map.get(list).size() == 1)
            {
                return map.get(list).get(0);
            }
        }

        return "";
    }
}
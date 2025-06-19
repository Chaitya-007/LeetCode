class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        String[] temp = new String[strs.length];
        HashMap<String, List<Integer> > map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < strs.length; i++)
        {
            StringBuilder sb = new StringBuilder(strs[i]);
            char[] ch = sb.toString().toCharArray();
            Arrays.sort(ch);
            StringBuilder ex = new StringBuilder("");
            ex.append(ch);
            
            if(map.containsKey(ex.toString()))
            {
                List<Integer> list = map.get(ex.toString());
                list.add(i);

                map.put(ex.toString(), new ArrayList<>(list));
            }
            else 
            {
                List<Integer> lt = new ArrayList<>();
                lt.add(i);
                map.put(ex.toString(), new ArrayList<>(lt));

            }

        }

        for(Map.Entry<String, List<Integer> > e : map.entrySet())
        {
            List<Integer> ind = e.getValue();
            List<String> str = new ArrayList<>();

            for(Integer val : ind)
            {
            str.add(strs[val]);

            }

            ans.add(str);
        }
        

        return ans;
    }
}
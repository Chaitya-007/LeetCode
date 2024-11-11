


class Solution {



    public int[] frequencySort(int[] nums) {
        // Store in map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val,0) + 1);
        }

        List<Pair<Integer, Integer> > list = new ArrayList<Pair<Integer, Integer>>();

        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            list.add(new Pair<Integer, Integer> (e.getKey(),e.getValue()));
        }

        Collections.sort(list, (a,b) -> 
        {
            if(a.getValue().equals(b.getValue()))
            {
                return Integer.compare(b.getKey(),a.getKey());
            }
            else
            {
                return Integer.compare(a.getValue(), b.getValue());
            }
        });

        List<Integer> res = new ArrayList<Integer>();

        for(Pair<Integer,Integer> p : list)
        {
            int n = p.getValue();
            while(n > 0)
            {
                res.add(p.getKey());
                n--;
            }
        }

        int[] ans = new int[res.size()];

        int ind = 0;
        for(Integer num : res)
        {
            ans[ind] = num;
            ind++;
        }

        return ans;

    }
}
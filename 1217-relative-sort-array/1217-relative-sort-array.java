class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[] arr = new int[arr1.length];

        for(int val : arr1)
        {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int ind = 0;
        for(int val : arr2)
        {
            if(map.containsKey(val))
            {
                int size = map.get(val);

                for(int i = 0; i < size; i++)
                {
                    arr[ind] = val;
                    ind++;
                }

                map.remove(val);
            }
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            int size = e.getValue();

            for(int i = 0; i < size; i++)
            {
                arr[ind] = e.getKey();
                ind++;
            }
        }

        return arr;
    }
}
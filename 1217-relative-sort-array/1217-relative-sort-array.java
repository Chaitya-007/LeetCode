class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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

        int start = ind;
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            int size = e.getValue();

            for(int i = 0; i < size; i++)
            {
                arr[ind] = e.getKey();
                ind++;
            }
        }

        for(int i = start; i < ind; i++)
        {
            int minInd = i;
            for(int j = i + 1; j < ind; j++)
            {
                if(arr[minInd] > arr[j])
                {
                    minInd = j;
                }
            }

            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
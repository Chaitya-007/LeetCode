class Solution {
    public int repeatedNTimes(int[] A) {
        // Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // for(int val : nums)
        // {
        //     mp.put(val, mp.getOrDefault(val,0) + 1);
        //     if(mp.get(val) == (nums.length/2))
        //     {
        //         return val;
        //     }
        // }

        // return -1;

        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;

    }
}
class Solution {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> hset = new HashSet<Integer>();
        int cnt = 0;

        for(int val : nums)
        {
            if(hset.contains(val))
            {
                cnt++;
                hset.remove(val);
            }
            else
            {

            hset.add(val);
            }
        }

        int[] arr = new int[2];
        arr[0] = cnt;
        arr[1] = hset.size();

        return arr;
        
    }
}
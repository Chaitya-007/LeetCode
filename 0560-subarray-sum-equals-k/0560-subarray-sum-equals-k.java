class Solution {
    public int subarraySum(int[] nums, int k) {

        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        int maxcount = 0;
        int sum = 0;


        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            int rem = sum - k;

            if(map.containsKey(rem))
            {
                maxcount += map.get(rem);
            }
            
            if(map.containsKey(sum))
            {
                map.put(sum,map.get(sum) + 1);
            }
            else
            {
                map.put(sum,1);
            }
        }

        return maxcount;
    }
}
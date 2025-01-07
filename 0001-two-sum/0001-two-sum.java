class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

       int[] arr = new int[2];

       for(int i = 0; i < nums.length; i++)
       {
        int key = target - nums[i];
        if(hmap.containsKey(key))
        {
            arr[0] = hmap.get(key);
            arr[1] = i;
            break;
        }
        hmap.put(nums[i],i);
       }

       return arr;
    }
}
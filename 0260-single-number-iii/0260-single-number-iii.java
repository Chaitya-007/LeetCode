class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val,0) + 1);
        }
        
        int[] arr = new int[2];
        int ind = 0;

        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            if(e.getValue() == 1)
            {
                arr[ind] = e.getKey();
                ind++;
            }
        }
        
        return arr;
    }
}
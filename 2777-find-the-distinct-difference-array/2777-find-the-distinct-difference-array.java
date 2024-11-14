class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer,Integer> prefixmap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> suffixmap = new HashMap<Integer,Integer>();

        for(int val : nums)
        {
            suffixmap.put(val, suffixmap.getOrDefault(val,0) + 1);
        }

        int i = 0;
        for(int val : nums)
        {
            prefixmap.put(val,prefixmap.getOrDefault(val,0) + 1);  
            suffixmap.put(val, suffixmap.get(val) - 1);

                if(suffixmap.get(val) == 0)
                {
                    suffixmap.remove(val);
                }

            nums[i] = (prefixmap.size() - suffixmap.size());
            i++;
            
        }

        return nums;


    }
}
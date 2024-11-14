class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
     int count = 0;
     int lessthan = 0;
     for(int val : nums)
     {
        if(val < target) lessthan++;
        if(val == target) count++;
     }   

    List<Integer> list = new ArrayList<Integer>();
    for(int i = 1; i <= count; i++)
    {
        list.add(lessthan);
        lessthan++;
    }

    return list;

    }
}
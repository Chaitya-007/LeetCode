class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> st = new HashSet<Integer>();
        for(int val : nums)
        {
            if(val > 0)
            {
                st.add(val);
            }
        }

        return st.size();
    }
}
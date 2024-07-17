class Solution {
    public int removeDuplicates(int[] nums) {

        Set<Integer> st = new TreeSet<>();
        
        for(int i : nums)
        {
            st.add(i);
        }

        int i = 0;
        for(int ele : st)
        {
            nums[i] = ele;
            i++;
        }
        return st.size();
    }
}
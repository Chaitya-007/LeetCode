class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && nums2[i] >= st.peek())
            {
                st.pop();
            }

            if(st.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i],st.peek());

            st.push(nums2[i]);
        }

        int[] ind = new int[nums1.length];
        int i = 0;

        for(int val : nums1)
        {
            ind[i] = map.get(val);
            i++;
        }

        return ind;
    }
}
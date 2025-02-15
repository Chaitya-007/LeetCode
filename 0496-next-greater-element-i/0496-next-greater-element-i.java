class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // T.C -> O(2*N)
        // S.C -> O(N) + O(N)

        Stack<Integer> st = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums2.length;

        for(int i = n - 1; i >= 0; i--)
        {

            while(!st.isEmpty() && nums2[i] > st.peek())
            {
                st.pop();
            }

            if(st.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i],st.peek());

            st.push(nums2[i]);
        }

        int[] arr = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++)
        {
           arr[i] = map.get(nums1[i]);
        }

        return arr;
    }
}
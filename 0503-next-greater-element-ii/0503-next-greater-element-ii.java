class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // T.C -> O(4*N)
        // S.C -> O(2*N)(stack) + O(N)(store elements)

        Stack<Integer> st = new Stack<>();

        int n = nums.length;

        int[] ans = new int[n];

        for(int i = (2*n - 1); i >= 0; i--) // -> O(2*N)
        {
            int ind = (i%n);

            while(!st.isEmpty() && nums[ind] >= st.peek())
            {
                st.pop(); // you are poping out at max 2*n elements (O(2*N))
            }

            if(i < n)
            {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[ind]); // you are pushing at max 2*n elements => (O(2*N))
        }

        return ans;
    }
}
class Solution {

     public int[] nse(int[] arr)
    {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ind = new int[n];

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? n : st.peek();

            st.push(i); 
        }

        return ind;
    }

     public int[] pse(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ind = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public int largestRectangleArea(int[] heights) {

        // T.C -> O(5*N)
        // S.C -> O(2*N) + O(2*N) + O(2*N)(prev,next) -> O(6N)
        int area = 0;
        int[] prev = pse(heights); // T.C -> O(2*N), S.C -> O(2*N)
        int[] next = nse(heights); // T.C -> O(2*N), S.C -> O(2*N)

        int n = heights.length;

        for(int i = 0; i < n; i++) // T.C -> O(N)
        {
            int left = prev[i];
            int right = next[i];

            int curr = (right - left - 1) * (heights[i]);
            area = Math.max(curr,area);
        }

        return area;
        
    }
}
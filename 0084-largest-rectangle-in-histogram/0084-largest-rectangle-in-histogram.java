class Solution {

    public int[] nse(int[] arr)
    {
        int n = arr.length;
        int[] ind = new int[n];
        Stack<Integer> st = new Stack<Integer>();

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
        int[] ind = new int[n];
        Stack<Integer> st = new Stack<Integer>();

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[i]  <= arr[st.peek()])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public int largestRectangleArea(int[] heights) {

        // T.C -> O(N)
        // S.C -> O(2N) + O(2*N)

        int maxo = Integer.MIN_VALUE;
        int n = heights.length;
        int[] next = nse(heights);
        int[] prev = pse(heights);

        for(int i = 0; i < n; i++)
        {
            int width = (next[i] - prev[i] - 1);
            int area = (width * heights[i]);
            maxo = Math.max(area, maxo);
        }

        return maxo;
        
    }
}
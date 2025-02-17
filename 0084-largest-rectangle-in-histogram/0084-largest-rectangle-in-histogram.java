class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int n = heights.length;
        int area = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                int element = heights[st.peek()];
                int right = i;
                st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int curr = (element * (right - left - 1));
                area = Math.max(area,curr);
            }

            st.push(i);
        }

        while(!st.isEmpty())
        {
            int right = n;
            int element = heights[st.peek()];
            st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            int curr = (element * (right - left - 1));
            area = Math.max(area,curr);
        }

        return area;
    }
}
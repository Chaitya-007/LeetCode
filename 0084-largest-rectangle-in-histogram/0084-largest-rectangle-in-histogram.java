class Solution {
    public int largestRectangleArea(int[] heights) {

        // One pass solution
        // T.C -> O(N)(traversal) + O(N)(stack)
        // S.C -> O(N)(stack)

        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int area = 0;

        for(int i = 0; i < n; i++) // O(N)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                int right = i;
                int element = heights[st.peek()];
                st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int curr = (element*(right - left - 1));
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
            int curr = (element*(right - left - 1));
            area = Math.max(area,curr);
        }

        return area;
    }
}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // T.C -> O(2*N)
        // S.C -> O(N)
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for(int i = 0; i < n; i++) // -> O(N)
        {
            // at max stack is pushing,poping N elements throughout journer -> O(N)

            if(asteroids[i] > 0) st.push(asteroids[i]);
            else
            {
                // it is sure that the current element is -ve

                // if top of stack is +ve and abs(-ve) > +ve
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) > st.peek())
                {
                    st.pop();
                }
                // either the stack have been empty or top of stack -> -ve or abs(-ve) <= +ve
                if(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) == st.peek())
                {
                    st.pop();
                }
                else
                {
                    if(st.isEmpty() || st.peek() < 0)
                    {
                        st.push(asteroids[i]);
                    }
                }
            }
        }

        int[] ind = new int[st.size()];

        for(int i = st.size() - 1; i >= 0; i--)
        {
            ind[i] = st.peek();
            st.pop();
        }

        return ind;
    }
}
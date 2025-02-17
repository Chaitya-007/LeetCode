class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // T.C -> O(2*N)
        // S.C -> O(N)
     Stack<Integer> st = new Stack<Integer>();
     int n = asteroids.length;

     for(int i = 0; i < n; i++)
     {
        if(asteroids[i] > 0) st.push(asteroids[i]);
        else
        {
            while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i]))
            {
                st.pop();
            }

            if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i]))
            {
                st.pop();
            }
            else if(st.isEmpty() || st.peek() < 0)
            {
                st.push(asteroids[i]);
            }
        }
     }   

    //  List<Integer> list = new ArrayList<Integer>();
     int[] ans = new int[st.size()];
     n = st.size();


     while(!st.isEmpty())
     {
        n = n - 1;
        ans[n] = st.peek();
        st.pop();
     }

     return ans;



    }
}
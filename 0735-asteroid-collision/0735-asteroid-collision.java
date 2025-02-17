class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();

        int n = asteroids.length;

        for(int i = 0; i < n; i++)
        {
            if(st.isEmpty())
            {
                st.push(asteroids[i]);
            }
            else
            {
                
                while(!st.isEmpty())
                {
        
                        if ( (asteroids[i] > 0 && st.peek() > 0) || (asteroids[i] < 0 && st.peek() < 0)  || (asteroids[i] > 0 && st.peek() < 0 ) )
                        {
                            st.push(asteroids[i]);
                            break;
                        }

                    else
                    {

                        if(Math.abs(asteroids[i]) == Math.abs(st.peek()))
                        {
                            st.pop();
                            break;
                        }

                        
                        else if(Math.abs(asteroids[i]) > Math.abs(st.peek()))
                        {
                            while(!st.isEmpty() && (asteroids[i] < 0 && st.peek() > 0) &&  Math.abs(asteroids[i]) > Math.abs(st.peek()))
                            {
                            st.pop();
                            }
                             if(st.isEmpty()) 
                             {
                                st.push(asteroids[i]);
                                break;
                             }
                        }
                        else
                        {
                            break;
                        }
                    }
                }

                
            }
        }

        int[] res = new int[st.size()];
        int resLen = res.length;

        for(int i = resLen - 1; i >= 0; i--)
        {
            res[i] = st.peek();
            st.pop();
        }

        return res;

    }
}
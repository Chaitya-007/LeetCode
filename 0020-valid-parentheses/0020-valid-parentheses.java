class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                char topval = st.peek();
                if(ch == ')')
                {
                    if(topval == '(')
                    {
                        st.pop();
                    }
                    else
                    {
                        st.push(ch);
                    }
                }
                else if(ch == ']')
                {
                    if(topval == '[')
                    {
                        st.pop();
                    }
                    else
                    {
                        st.push(ch);
                    }

                }
                else if(ch == '}')
                {
                    if(topval == '{')
                    {
                        st.pop();
                    }
                    else
                    {
                        st.push(ch);
                    }

                }
                else 
                {
                    st.push(ch);
                }
            }
        }

        return st.isEmpty();
        
    }
}
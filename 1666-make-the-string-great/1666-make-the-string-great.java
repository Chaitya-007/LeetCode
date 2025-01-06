class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder("");

        for(char ch : s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                if('A'<= ch && ch <= 'Z')
                {
                    char topval = st.peek();
                    if('a' <= topval && topval <= 'z')
                    {
                        int diff = (int)(topval - ch);
                        if(diff == 32)
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
                else
                {
                     char topval = st.peek();
                    if('A' <= topval && topval <= 'Z')
                    {
                        int diff = (int)(ch - topval);
                        if(diff == 32)
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
        }

        while(!st.isEmpty())
        {
            sb.insert(0,st.peek());
            st.pop();
        }

        return sb.toString();
    }
}
class Solution {
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                if('A' <= ch && ch <= 'Z')
                {
                    char val = (char) (ch + 32);
                    if(val == st.peek())
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
                    char val = (char) (ch - 32);
                    if(val == st.peek())
                    {
                        st.pop();
                    }
                    else
                    {
                    st.push(ch);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder("");

        while(!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }

        return sb.reverse().toString();
        
    }
}
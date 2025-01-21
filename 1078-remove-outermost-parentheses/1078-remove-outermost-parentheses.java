class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<Character>();

        int n = s.length();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                if(ch == '(')
                {      
                    
                        sb.append(ch);
                        st.push(ch);
                }
                else
                {
                    if(st.size() > 1)
                    {
                        sb.append(ch);
                    }
                   
                    st.pop();
                }
            }
        }

        return sb.toString();
    }
}
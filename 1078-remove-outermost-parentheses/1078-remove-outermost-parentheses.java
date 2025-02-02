class Solution {
    public String removeOuterParentheses(String s) {
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
                if(ch == ')')
                {
                    if(st.size() > 1)
                    {
                        sb.append(ch);
                    }
                    st.pop();
                }
                else
                {
                    st.push(ch);
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
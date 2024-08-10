class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<Character>();
        int n = s.length();
        String str = "";

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '(')
            {
                if(!st.isEmpty())
                {
                    str += '(';
                }
                st.push('(');      
            }
            else 
            {
                if(!st.isEmpty())
                {
                    if(st.size() == 1)
                    {
                        st.pop();
                    }
                    else
                    {
                        str += ')';
                        st.pop();
                    }
                }
            }
        }

        return str;
    }
}
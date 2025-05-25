class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                char top = st.peek();
                int diff = Math.abs(top - ch);
                if(diff == 1 || diff == 25)
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty())
        {
            sb.insert(0,st.peek());
            st.pop();
        }

        return sb.toString();
    }
}
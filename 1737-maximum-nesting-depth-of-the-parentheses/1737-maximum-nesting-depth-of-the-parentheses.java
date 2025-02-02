class Solution {
    public int maxDepth(String s) {
        int ans = -1;

        Stack<Character> st = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if(ch == '(' || ch == ')')
            {

            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                if(ch == '(')
                {
                    st.push(ch);
                }
                else
                {
                    st.pop();
                }
            }
            }

            ans = Math.max(ans,st.size());
        }

        return ans;
    }
}
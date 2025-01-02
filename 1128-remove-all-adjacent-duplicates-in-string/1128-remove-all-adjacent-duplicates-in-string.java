class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                if(st.peek() == ch)
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
            sb.append(st.peek());
            st.pop();
        }

        return sb.reverse().toString();
        
    }
}
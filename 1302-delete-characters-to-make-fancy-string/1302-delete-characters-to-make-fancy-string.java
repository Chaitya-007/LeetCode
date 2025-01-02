class Solution {
    public String makeFancyString(String s) {
        Stack<Character> st = new Stack<Character>();
        int cnt = 1;

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
                    cnt++;
                    if(cnt<=2)
                    {
                        st.push(ch);
                    }
                }
                else
                {
                    st.push(ch);
                    cnt = 1;
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
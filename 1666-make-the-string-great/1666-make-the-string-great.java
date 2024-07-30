class Solution {
    public String makeGood(String s) {
        if(s.length() == 0)
        {
            return s;
        }

        // StringBuilder sb = new StringBuilder("");

        // for(int i = 0; i < s.length(); i++)
        // {
        //     int len = sb.length();

        //     if(len > 0)
        //     {
        //         int num = Math.abs(s.charAt(i) - sb.charAt(len - 1));
        //         if(num == 32)
        //         {
        //             sb.deleteCharAt(len - 1);
        //         }
        //         else
        //         {
        //             sb.append(s.charAt(i));
        //         }
        //     }
        //     else
        //     {
        //         sb.append(s.charAt(i));
        //     }
        // }

        // return sb.toString();

        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(st.isEmpty())
            {
                st.push(ch);
            }
            else
            {
                int num = Math.abs(ch - st.peek());
                if(num == 32)
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
            char ch = st.peek();
            sb.append(ch);
            st.pop();
        }

        sb.reverse();
        return sb.toString();
    }
}
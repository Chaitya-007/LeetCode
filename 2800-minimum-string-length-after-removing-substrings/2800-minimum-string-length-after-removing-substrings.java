class Solution {
    public int minLength(String s) {

        // int cnt = 0;
        // StringBuilder sb = new StringBuilder("");
        // for(int i = 0; i < s.length(); i++)
        // {
        //     int len = sb.length();

        //     if(len > 0)
        //     {
        //         if(s.charAt(i) == 'B' && sb.charAt(len - 1) == 'A')
        //         {
        //             sb.deleteCharAt(len - 1);
        //         }
        //         else if(s.charAt(i) == 'D' && sb.charAt(len - 1) == 'C')
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

        // // System.out.println(sb);

        // return sb.length();

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
                if(s.charAt(i) == 'B' && st.peek() == 'A')
                {
                    st.pop();
                }
                else if(s.charAt(i) == 'D' && st.peek() == 'C')
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
        }

        return st.size();
    }
}
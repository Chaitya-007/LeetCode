class Solution {
    public String removeDuplicates(String s) {
        
        // Stack<Character> st = new Stack<Character>();

        // for(int i = 0; i < s.length(); i++)
        // {
        //     if(st.isEmpty())
        //     {
        //         st.push(s.charAt(i));
        //     }
        //     else 
        //     {
        //         if(st.peek() == s.charAt(i))
        //         {
        //             st.pop();
        //         }
        //         else
        //         {
        //             st.push(s.charAt(i));
        //         }
        //     }
        // }

        // StringBuilder sb = new StringBuilder("");

        // while(!st.isEmpty())
        // {
        //     char ch = st.pop();
        //     sb.append(ch);
        // }

        // sb.reverse();

        // return sb.toString();

        StringBuilder sb = new StringBuilder("");


        for(char ch : s.toCharArray())
        {
            int len = sb.length();

            if(len > 0 && ch == sb.charAt(len - 1))
            {
                sb.deleteCharAt(len - 1);
            }
            else
            {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
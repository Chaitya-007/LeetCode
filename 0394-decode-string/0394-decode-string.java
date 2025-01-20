class Solution {
    public String decodeString(String s) {

        int startInd = -1;

        int n = s.length();
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);

           if(ch != ']')
           {
            st.push(ch);
           }
            else
            {

                StringBuilder sb = new StringBuilder("");
                while(st.peek() != '[')
                {
                    char chv = st.peek();
                    st.pop();
                    sb.insert(0,chv);
                }

                st.pop();

                StringBuilder numStr = new StringBuilder("");

                while(!st.isEmpty() && Character.isDigit(st.peek()))
                {
                    numStr.insert(0,st.peek());
                    st.pop();
                }

                int num = Integer.valueOf(numStr.toString());
                for(int j = 1; j <= num; j++)
                {
                    for(char chs : sb.toString().toCharArray())
                    {
                        st.push(chs);
                    }
                }
            }

        }

        StringBuilder res = new StringBuilder("");

        while(!st.isEmpty())
        {
            res.insert(0,st.peek());
            st.pop();
        }

        return res.toString();
        
    }
}
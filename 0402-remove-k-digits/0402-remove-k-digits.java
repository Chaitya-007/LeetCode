class Solution {
    public String removeKdigits(String num, int k) {
        // Get rid of larger elements
        // Keep track of smaller elements

        int n = num.length();

        if(k == n)
        {
            return "0";
        }

        Stack<Character> st = new Stack<Character>();
        int i = 0;

        while(i < n)
        {
            while(k  > 0 && !st.isEmpty() && ( st.peek() - '0') > (num.charAt(i) - '0') )
            {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));

            i++;

            if(k == 0)
            {
                break;
            }
        }

        while(i < n)
        {
            st.push(num.charAt(i));
            i++;
        }

        while(k!=0)
        {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder("");

        while(!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }

        String str = sb.reverse().toString();

        int t = 0;
        while(t < str.length() && str.charAt(t) == '0')
        {
            t++;
        }

        if(t == str.length()) return "0";

        return str.substring(t,str.length());
    }
}
class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        int n = num.length();
        if(k == n) return "0";
        int i = 0;

        for(char ch : num.toCharArray())
        {
            
            while(k > 0 && !st.isEmpty() && (st.peek() - '0') > (ch - '0') )
            {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        if(st.isEmpty()) return "0";

        while(k > 0)
        {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder("");

        while(!st.isEmpty())
        {
            sb.insert(0,st.peek());
            st.pop();
        }

        i = 0;
        while(i < sb.length() && sb.charAt(i) == '0')
        {
            i++;
        }

        if(i == sb.length()) return "0";

        return sb.toString().substring(i,sb.length());
        
    }
}
class Solution {
    public String removeKdigits(String num, int k) {

        // Get rid of large elements
        // Keep track of small elements
        // T.C -> O(3*N) + O(K)
        // S.C -> O(N)(stack) + O(N)(storing result)

        Stack<Character> st = new Stack<>();

        int n = num.length();
        if(k == n) return "0";
        int i = 0;

        for(char ch : num.toCharArray()) // O(N)
        {
            
            while(k > 0 && !st.isEmpty() && (st.peek() - '0') > (ch - '0') )
            {
                st.pop();
                k--;
            }

            st.push(ch);
        }


        while(k > 0) // O(k)
        {
            st.pop();
            k--;
        }
        
        if(st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder("");

        while(!st.isEmpty()) // traversal + reverse => O(N)
        {
            sb.insert(0,st.peek());
            st.pop();
        }

        i = 0;
        while(i < sb.length() && sb.charAt(i) == '0') // O(N) => if entire stack is of "0" 
        {
            i++;
        }

        if(i == sb.length()) return "0";

        return sb.toString().substring(i,sb.length());
        
    }
}
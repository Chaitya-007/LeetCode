class Solution {

    public static boolean isBalance(String str)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '[')
            {
                st.push('[');
            }
            else if(str.charAt(i) == ']')
            {
                if(st.isEmpty())
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
                
            }
        }

        return true;
    }

    
    public int minSwaps(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        int cnt = 0;
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ']' && st.isEmpty())
            {
                cnt++;
            }
            else if(s.charAt(i) == ']' && st.isEmpty() == false)
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }

        return (cnt+ 1 )/2;
    }
}
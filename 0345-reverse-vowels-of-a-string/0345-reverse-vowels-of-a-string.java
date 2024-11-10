class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";

        Stack<Character> st = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if(vowel.indexOf(ch) >= 0)
            {
                st.push(ch);
            }
        }

        char[] ch = s.toCharArray();

        for(int i = 0; i < s.length(); i++)
        {
            if(vowel.indexOf(s.charAt(i)) >= 0)
            {
                ch[i] = st.peek();
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(char val : ch)
        {
            sb.append(val);
        }

        return sb.toString();
    }
}
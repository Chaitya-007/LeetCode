class Solution {
    public int minimizedStringLength(String s) {
        HashSet<Character> ht = new HashSet<Character>();

        // for(char ch : s.toCharArray())
        // {
        //     ht.add(ch);
        // }

        // return ht.size();

        // M2
        // return (int) s.chars().distinct().count();

        // M3
        String buffer = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(!buffer.contains(String.valueOf(s.charAt(i))))
            {
                buffer += s.charAt(i);
            }
        }

        return buffer.length();
    }
}
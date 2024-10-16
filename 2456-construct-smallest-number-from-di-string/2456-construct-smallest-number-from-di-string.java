class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder("");
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i <= pattern.length(); i++)
        {
            str.append((char)('1' + i));
            if(i == pattern.length() || pattern.charAt(i) == 'I')
            {
                res.append(str.reverse());
                str = new StringBuilder("");
            }
        }

        return res.toString();
    }
}
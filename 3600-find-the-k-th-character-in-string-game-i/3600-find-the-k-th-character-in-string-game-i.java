class Solution {
    public char kthCharacter(int k) {
        
        StringBuilder sb = new StringBuilder("");
        String s = "a";
        int n;
        while(s.length() < k)
        {
            sb.setLength(0);
            sb.append(s);

            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == 'z')
                {
                    sb.append('a');
                }
                else
                {
                    char ch = (char)(s.charAt(i) + 1);
                    sb.append(ch);
                }

                if(sb.length() == k)
                {
                    return sb.charAt(sb.length() - 1);
                }

            }

            s = sb.toString();
           
        }

        return 'a';
    }
}
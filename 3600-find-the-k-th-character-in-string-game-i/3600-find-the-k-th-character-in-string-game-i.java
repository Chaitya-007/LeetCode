class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        while(sb.length() < k)
        {
            StringBuilder next = new StringBuilder("");
            int n = sb.length();

            for(int i = 0; i < n; i++)
            {
                char ch = sb.charAt(i);

                if(ch == 'z')
                {
                    next.append('a');
                }
                else
                {
                    char next_char = (char) (sb.charAt(i) + 1);
                    sb.append(next_char);
                }
            }

            sb.append(next);
        }

        return sb.charAt(k-1);


    }
}
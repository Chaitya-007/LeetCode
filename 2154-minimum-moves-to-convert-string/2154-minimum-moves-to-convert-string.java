class Solution {
    public int minimumMoves(String s) {
        int cnt = 0;
        int i = 0;
        int n = s.length();
        int mov = 0;

        while(i < n)
        {
            if(s.charAt(i) == 'O')
            {
                i++;
            }
            else
            {
                mov++;
                i += 3;
            }
        }

        return mov;
    }
}
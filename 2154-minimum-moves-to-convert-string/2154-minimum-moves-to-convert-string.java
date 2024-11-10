class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        int mov = 0;
        int i = 0;
        while(i < n)
        {
            String str = s.substring(i, Math.min(n,i+3));

            int ind = 0;
            for(ind = 0; ind < str.length(); ind++)
            {
                if(str.charAt(ind) == 'X')
                {
                    break;
                }
            }


            if(ind == 0)
            {
                mov++;
                i = i + 3;
            }
            else
            {
                i = i + ind;
            }
        }
        return mov;
    }
}
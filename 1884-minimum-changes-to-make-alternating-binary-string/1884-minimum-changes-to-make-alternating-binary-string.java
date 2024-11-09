class Solution {
    public int minOperations(String s) {
        int minop1 = 0;
        int minop2 = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(i%2 == 0)
            {
                if(s.charAt(i) == '0')
                {
                    minop2++;
                }
                else
                {
                    minop1++;
                }
            }
            else
            {
                if(s.charAt(i) == '0')
                {
                    minop1++;
                }
                else
                {
                    minop2++;
                }
            }
        }

        return Math.min(minop1,minop2);
    }
}
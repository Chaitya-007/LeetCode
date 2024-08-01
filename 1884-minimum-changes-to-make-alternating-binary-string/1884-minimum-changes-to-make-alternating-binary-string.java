class Solution {
    public int minOperations(String s) {

        StringBuilder sb1 = new StringBuilder("");
        for(int i = 0; i < s.length(); i++)
        {
            if(i%2 == 0)
            {
                sb1.append('0');
            }
            else
            {
                sb1.append('1');
            }
        }

        StringBuilder sb2 = new StringBuilder("");

        for(int i = 0; i < s.length(); i++)
        {
            if(i%2 == 0)
            {
                sb2.append('1');
            }
            else
            {
                sb2.append('0');
            }
        }

        int diff1 = 0;
        int diff2 = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(sb1.charAt(i) != s.charAt(i))
            {
                diff1 += 1;
            }
            if(sb2.charAt(i) != s.charAt(i))
            {
                diff2 += 1;
            }
        }

        return Math.min(diff1,diff2);
    }
}
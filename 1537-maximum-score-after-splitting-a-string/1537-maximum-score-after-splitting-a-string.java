class Solution {

    public static int countchar(String str, char ch)
    {
        int freq = 0;
        char[] charray = str.toCharArray();

        for(char val : charray)
        {
            if(val == ch)
            {
                freq++;
            }
        }

        return freq;
    }

    public int maxScore(String s) {
        int maxo = 0;
    
        int n = s.length();
        for(int i = 0; i <= n - 2; i++)
        {
            String left_part = s.substring(0,i+1);
            String right_part = s.substring(i+1,n);
            int leftcnt = countchar(left_part,'0');
            int rightcnt = countchar(right_part,'1');
            int sum = leftcnt + rightcnt;
            if(maxo < sum)
            {
                maxo = sum;
            }
        }

        return maxo;
    }
}
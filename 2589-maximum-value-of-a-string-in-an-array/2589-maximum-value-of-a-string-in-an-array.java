class Solution {
    public int maximumValue(String[] strs) {

        int maxo = 0;
        for(String str : strs)
        {
            int n = str.length();
            int num = 0;

            for(int i = 0; i < n; i++)
            {
                char ch = str.charAt(i);
                if('0' <= ch && ch <= '9')
                {
                    int val = (int)(ch - '0');
                    num = val + ((num)*10);
                }
                else
                {
                    num = str.length();
                    break;
                }
            }

            if(maxo < num)
            {
                maxo = num;
            }
        }

        return maxo;
    }
}
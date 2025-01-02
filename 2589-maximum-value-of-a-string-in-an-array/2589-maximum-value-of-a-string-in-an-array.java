class Solution {

    public static int getValue(String s)
    {
        int num = 0;
        for(char ch : s.toCharArray())
        {
            if('a' <= ch && ch <= 'z')
            {
                return s.length();
            }
            else
            {
                int val = (int)(ch - '0');
                num = num*10 + val;
            }
        }

        return num;
    }

    public int maximumValue(String[] strs) {
        
        int result = 0;

        for(String str : strs)
        {
            int ans = getValue(str);
            result = Math.max(result,ans);
        }

        return result;
    }
}
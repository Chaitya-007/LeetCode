class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for(String str : words)
        {
            if(str.length() > s.length())
            {
                continue;
            }

            boolean flag = true;

            for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) != s.charAt(i))
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                cnt++;
            }
        }

        return cnt;
    }
}
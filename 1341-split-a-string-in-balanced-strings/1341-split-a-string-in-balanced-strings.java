class Solution {
    public int balancedStringSplit(String s) {
        int str_count = 0;
        int cnt = 0;

        for(int i = 0; i < s.length(); i++)
        {
        //    cnt = s.charAt(i) == 'R' ? ++cnt : --cnt; // use preincrement

            if(s.charAt(i) == 'R')
            {
                cnt++;
            }
            else
            {
                cnt--;
            }

            if(cnt == 0)
            {
               
                str_count++;
            }
        }

        return str_count;
    }
}
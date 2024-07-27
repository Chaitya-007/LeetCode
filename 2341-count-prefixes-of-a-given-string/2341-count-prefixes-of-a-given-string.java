class Solution {
    public int countPrefixes(String[] words, String s) {
        // return 0;
        int cnt = 0;

        // for(String str : words)
        // {
        //     boolean flag = true;
        //     if(str.length() > s.length())
        //     {
        //         continue;
        //     }
        //     for(int i = 0; i < str.length(); i++)
        //     {
        //         if(s.charAt(i) != str.charAt(i))
        //         {
        //             flag = false;
        //         }
        //     }

        //     if(flag)
        //     {
        //         cnt++;
        //     }
        // }

        for(String str : words)
        {
            if(s.startsWith(str))
            {
                cnt++;
            }
        }

        return cnt;
    }
}
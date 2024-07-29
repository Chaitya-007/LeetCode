class Solution {
public:
    int countPrefixes(vector<string>& words, string s)
    {

        // int count = 0;
        // for(int i = 0; i < words.size(); i++)
        // {
        //     string str = words[i];
        //     if(s.find(str) == 0)
        //     {
        //         count++;
        //     }
        // }  

        // return count; 

        // int count = 0;
        // for(int i = 0; i < words.size(); i++)
        // {
        //     string str = words[i];
        //     if(str.front() == s.front())
        //     {
        //         int flag = 1;
        //         for(int i = 0; i < str.length(); i++)
        //         {
        //             if(str[i] != s[i])
        //             {
        //                 flag = 2;
        //                 break;
        //             }
        //         }

        //         if(flag == 1)
        //         {
        //             count++;
        //         }
        //     }
        // }

        // return count; 

        // Third approach

        int count = 0;
        for(int i = 0; i < words.size(); i++)
        {
            string str = words[i];
            string res = s.substr(0,str.length());
            if(str == res)
            {
                count++;
            }
        }

        return count;
    }
};
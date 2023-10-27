class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        // string res;
        // int flag = 1;
        // // we can also sort
        // sort(strs.begin(),strs.end());

        // for(int j = 0; j < strs[0].size(); j++)
        // {
        //     for(int i = 0; i < (strs.size() - 1); i++)
        //     {
        //         if(strs[i][j] == strs[i+1][j])
        //         {

        //         }
        //         else
        //         {
        //             flag = 2;
        //         }
        //     }

        //     if(flag == 2)
        //     {
        //         break;
        //     }
        //     else
        //     {
        //         res += strs[0][j];
        //     }
        // }
        
        // return res;

        sort(strs.begin(),strs.end());
        string first = strs[0];
        string last = strs[strs.size() - 1];
        string res;
        long count = 0;

        while(count < first.length() and count < last.length())
        {
            if(first[count] == last[count])
            {
                count++;
            }
            else
            {
                break;
            }
        }

        return first.substr(0,count);
    }
};
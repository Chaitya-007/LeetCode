class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string res;
        int flag = 1;

        for(int j = 0; j < strs[0].size(); j++)
        {
            for(int i = 0; i < (strs.size() - 1); i++)
            {
                if(strs[i][j] == strs[i+1][j])
                {

                }
                else
                {
                    flag = 2;
                }
            }

            if(flag == 2)
            {
                break;
            }
            else
            {
                res += strs[0][j];
            }
        }
        
        return res;
    }
};
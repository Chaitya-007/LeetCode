class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) 
    {
        int consistent = 0;
        unordered_map<char, int> hashset;
        int flag = 1;
        for(int i = 0; i < allowed.length(); i++)
        {
            hashset[allowed[i]]++;
        }
        for(int i = 0; i < words.size(); i++)
        {
            flag = 1;
            for(int j = 0; j < words[i].length(); j++)
            {
                if(hashset.find(words[i][j]) == hashset.end())
                {
                    flag = 2;
                    break;
                }
            }
            if(flag == 1)
            {
                consistent++;
            }

        }

        return consistent;
        
    }
};
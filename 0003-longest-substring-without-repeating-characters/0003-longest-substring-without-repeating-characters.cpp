class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<int> sec;

        if(s.length() == 0)
        {
            return 0;
        }

        if(s.length() == 1)
        {
            return 1;
        }

        int maxo = 0;

        for(int i = 0; i < s.length(); i++)
        {
            unordered_set<char> hashset;
            hashset.insert(s[i]);
            // int count = 1;
            for(int j = i + 1; j < s.length(); j++)
            {
                if(hashset.find(s[j]) != hashset.end())
                {
                    break;
                }
                
                hashset.insert(s[j]);
                // count++;
            }

            // sec.insert(hashset.size());
            int n = hashset.size();
            maxo = max(maxo,n);
        }
        // auto itr = sec.end();
        // itr--;
        // return (*itr);
        return maxo;
        
    }
};
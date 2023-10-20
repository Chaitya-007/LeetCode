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

        for(int i = 0; i < s.length(); i++)
        {
            set<char> hashset;
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

            sec.insert(hashset.size());
        }
        auto itr = sec.end();
        itr--;
        return (*itr);
        
    }
};
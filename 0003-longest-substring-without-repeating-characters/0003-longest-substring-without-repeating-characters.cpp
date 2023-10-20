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

        // int maxo = 0;

        // for(int i = 0; i < s.length(); i++)
        // {
        //     unordered_set<char> hashset;
        //     hashset.insert(s[i]);
        //     // int count = 1;
        //     for(int j = i + 1; j < s.length(); j++)
        //     {
        //         if(hashset.find(s[j]) != hashset.end())
        //         {
        //             break;
        //         }
                
        //         hashset.insert(s[j]);
        //         // count++;
        //     }

        //     // sec.insert(hashset.size());
        //     int n = hashset.size();
        //     maxo = max(maxo,n);
        // }
        // // auto itr = sec.end();
        // // itr--;
        // // return (*itr);
        // return maxo;

        // ******************************************
        // using set

        // int right = 0;
        // int left = 0;
        // int maxLength = 0;
        // unordered_set<char> hashset;
        // int n = s.length();

        // while(right < n)
        // {
        //     if(hashset.count(s[right]) == 0)
        //     {
        //         hashset.insert(s[right]);
        //         maxLength = max(maxLength, right - left + 1);
        //         right++;
        //     }
        //     else
        //     {
        //         while(hashset.count(s[right]))
        //         {
        //             hashset.erase(s[left]);
        //             left++;
        //         }
        //     }
        // }
        // return maxLength;

        // ********************************
        // using unordered map
        int left = 0;
        int right = 0;
        int maxLength = 0;
        unordered_map<char, int> map;

        while(right < s.length())
        {
            if(map.count(s[right]) == 0 || map[s[right]] < left)
            {
                map[s[right]] = right;
                maxLength = max(maxLength, right - left + 1);
            }
            else
            {
                left = map[s[right]] + 1;
                map[s[right]] = right;
            }
            right++;
        }

        return maxLength;
        
    }
};
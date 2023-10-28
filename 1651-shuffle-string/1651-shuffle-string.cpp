class Solution {
public:
    string restoreString(string s, vector<int>& indices) {
        map<int,char> mp;
        for(int i = 0; i < s.length(); i++)
        {
            mp[indices[i]] = s[i];
        }

        // string res;
        s = "";
        for(auto itr = mp.begin(); itr != mp.end(); itr++)
        {
            // res += (itr->second);
            s += (itr->second);
        }
        // return res;
        return s;
        
    }
};
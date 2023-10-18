class Solution {
public:
    int romanToInt(string s) {
        // unordered_map<char, int> mp;
        // mp['I'] = 1;
        // mp['V'] = 5;
        // mp['X'] = 10;
        // mp['L'] = 50;
        // mp['C'] = 100;
        // mp['D'] = 500;
        // mp['M'] = 1000;

        // int n = s.length();
        // long long num = 0;
        // int i = 0;

        // while(i < n)
        // {
        //     if(i + 1 == n)
        //     {
        //         num += (mp[s[i]]);
        //         i++;
                
        //     }

        //     else if(mp[s[i]] >= mp[s[i+1]])
        //     {
                
        //         num += (mp[s[i]]);
        //         i++;
        //     }

        //     else if(mp[s[i]] < mp[s[i+1]])
        //     {
        //         num += ( (mp[s[i+1]]) - (mp[s[i]]) );
        //         i = i + 2;

        //     }
        // }

        // return num;

        
        unordered_map<char, int> mp;
        mp['I'] = 1;
        mp['V'] = 5;
        mp['X'] = 10;
        mp['L'] = 50;
        mp['C'] = 100;
        mp['D'] = 500;
        mp['M'] = 1000;
        
        int ans = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(mp[s[i]] < mp[s[i+1]])
            {
                ans -= mp[s[i]];
            }
            else
            {
                ans += mp[s[i]];
            }
        }
        return ans;
    }
    
};
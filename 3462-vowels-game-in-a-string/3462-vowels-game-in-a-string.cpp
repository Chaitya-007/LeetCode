class Solution {
public:
    bool doesAliceWin(string s) {

        int n = s.size();
        unordered_map<char, int> mp;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' ||
                s[i] == 'u') {
                mp[s[i]]++;
            }
        }
        int sum = 0;
        for (auto it : mp) {
            sum = sum + it.second;
        }
        if (sum == 0) {
            return false;
        }
        return true;
        
        // while(1)
        // {
            
        // int maxvowel_count = 0;
        // int maxvowel_index = 0;
        // int count = 0;
        
        // for(int i = 0; i < s.length(); i++)
        // {
        //     if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
        //     {
        //         count++;
        //     if(count%2 == 1)
        //     {
        //         maxvowel_count = count;
        //         maxvowel_index = i;
        //     }

        //     }
            
            
        // }
        
        // if(count == 0)
        // {
        //     return false;
        // }
        
        
        // int n = s.length();
        // string str = s.substr(maxvowel_index + 1, n);
        //     cout<<"Alice "<<str<<endl;
        
        
        // int maxconsonant_count = 0;
        // int maxconsonant_index = 0;
        // int cnt = 0;
        
        // for(int i = 0; i < str.length(); i++)
        // {
        //     if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u')
        //     {
        //         cnt++;
        //     if(cnt%2 == 0)
        //     {
        //         // cout<<str[i];
        //         maxconsonant_count = cnt;
        //         maxconsonant_index = i;
        //     }

        //     }
            
            
        // }
        
        // if(cnt == 0)
        // {
        //     return true;
        // }
            
        
        
        // int sn = str.length();
        // // cout<<maxconsonant_count;
        // s = str.substr(maxconsonant_index + 1, sn);
        
        //     cout<<"Bob "<<s<<endl;
        // }
        
    }
};
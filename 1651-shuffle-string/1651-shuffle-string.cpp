class Solution {
public:
    string restoreString(string s, vector<int>& indices) {
        // map<int,char> mp;
        // for(int i = 0; i < s.length(); i++)
        // {
        //     mp[indices[i]] = s[i];
        // }

        // string res;
        // for(auto itr = mp.begin(); itr != mp.end(); itr++)
        // {
        //     res += (itr->second);
            
        // }
        // return res;

         for(int i=0;i<indices.size();i++)
        {
            
              while(indices[i]!=i)
              {
                  swap(s[i],s[indices[i]]);
                  swap(indices[i],indices[indices[i]]);
                       
              }
        }
        
       
        return s;
        
    }
};
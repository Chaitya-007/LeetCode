class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges)
    {
//         map<int, bool> mp;
//         for(int i = 0; i < edges.size(); i++)
//         {
//               for(int j = 0; j < edges[i].size(); j++)
//               {
//                   mp[edges[i][j]] = false;
//               }
            
//         }
        
//          for(int i = 0; i < edges.size(); i++)
//         {
              
//                   mp[edges[i][1]] = true;
              
            
//         }
        
        
//         int count = 0;
//         for(auto itr = mp.begin(); itr != mp.end(); itr++)
//         {
//             if(itr->second == false)
//             {
//                 count++;
//             }
//         }
        
//         if(count>1)
//         {
//             return -1;
//         }
        
//         vector<int> vec;
        
//         for(auto itr = mp.begin(); itr != mp.end(); itr++)
//         {
//             if(itr->second == false)
//             {
//                 return (itr->first);
//             }
//         }
        
//         return -1;
        
      
        
        
        vector<int>vec(n,0);
        
        for(auto itr : edges)
        {
            vec[itr[1]] = 1;
        }
        
        int count = 0;
        
        for(int i = 0; i < vec.size(); i++)
        {
            if(vec[i] == 0)
            {
                count++;
            }
        }
        
        if(count > 1)
        {
            return -1;
        }
        
        for(int i = 0; i < vec.size(); i++)
        {
            if(vec[i] == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
};
class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        // Brute Force
        
        // ***********************************
        // M-1 
        // T.C -> O(N)
        // S.C -> O(N)
        // unordered_set<int> st(arr.begin(),arr.end());
        

        // int low = 0;
        // int cnt = 0;

        // while(cnt < k)
        // {
        //     low++;
        //     if(st.find(low) == st.end())
        //     {
        //         cnt++;
        //     }
            
        // }

        // return low;

        // *******************************************************
        // M-2
        int low = 0;
        int cnt = 0;
        int ind = 0;
        int n = arr.size();

        while(cnt < k)
        {
            low++;
            if(ind < n)
            {
                if(low != arr[ind])
                {
                    cnt++;
                }
                else
                {
                    ind++;
                }
            }
            else
            {
                cnt++;
            }
        }

        return low;
    
        
        
    }
};
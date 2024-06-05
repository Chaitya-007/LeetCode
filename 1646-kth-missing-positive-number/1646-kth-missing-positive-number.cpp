class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        // Brute Force
        unordered_set<int> st(arr.begin(),arr.end());
        

        int low = 0;
        int cnt = 0;

        while(cnt < k)
        {
            low++;
            if(st.find(low) == st.end())
            {
                cnt++;
            }
            
        }

        return low;
        
        
    }
};
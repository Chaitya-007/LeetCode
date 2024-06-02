class Solution {
public:
    int countDays(int days, vector<vector<int>>& v) {
        // unordered_set<int> st;
        // int n = meetings.size();
        // for(int i = 0; i < n; i++)
        // {
        //     int start = meetings[i][0];
        //     int end = meetings[i][1];
            
        //     if(st.find(start) == st.end() || st.find(end) == st.end())
        //     {
                
            
        //     while(start <= end)
        //     {
        //         st.insert(start);
        //         start++;
        //         if(st.size() == days)
        //         {
        //             return 0;
        //         }
        //     }
                
        //     }
        // }
        
        // return (days - st.size());

         int ans = 0;
        sort(v.begin() , v.end());
        int prev = 0;
        for(int i = 0; i < v.size(); i++) {
            if(v[i][0] > prev)
                ans += v[i][0] - prev - 1;
            prev = max(prev , v[i][1]);
            
        }
        if(days > prev) ans += days - prev;
        return ans;
    }
};
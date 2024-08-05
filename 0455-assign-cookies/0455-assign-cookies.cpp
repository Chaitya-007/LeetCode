class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int visited[g.size()];
        for(int i = 0; i < g.size(); i++)
        {
            visited[i] = 0;
        }
        int cnt = 0;

        for(int i = s.size() - 1 ; i >= 0; i-- )
        {
            int ele = INT_MIN;
            int maxo = s[i];
            int ind = -1;
            for(int j = 0; j < g.size(); j++)
            {
                if(g[j] <= maxo && visited[j] == 0)
                {
                    if(ele <= g[j])
                    {
                        ele = g[j];
                        ind = j;
                    }
                }
            }
            if(ind != -1)
            {
                cnt++;
                visited[ind] = 1;
            }
        }

        return cnt;
    }
};
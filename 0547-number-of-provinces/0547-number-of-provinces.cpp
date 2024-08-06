class Solution {
public:

    void dfsFunc(int node, int vis[], vector<int> &dfs, vector<int> adj[])
    {
        vis[node] = 1;
        for(auto it : adj[node])
        {
            if(vis[it] != 1)
            {
                dfsFunc(it,vis,dfs,adj);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int v = isConnected.size();
        int vis[v+1];
        for(int i = 0; i < (v+1); i++)
        {
            vis[i] = 0;
        }

        vector<int> adj[v+1];

        for(int i = 0; i < isConnected.size(); i++)
        {
            for(int j = 0; j < isConnected.size(); j++)
            {
                if(i != j && isConnected[i][j] == 1)
                {
                    int u = i + 1;
                    int v = j + 1;
                    adj[u].push_back(v);
                    adj[v].push_back(u);
                }
            }
        }

        int cnt = 0;
        vector<int> dfs;
        
        for(int node = 1; node <= v; node++)
        {
            if(vis[node] != 1)
            {
                dfsFunc(node,vis,dfs,adj);
                cnt++;
            }
        }

        return cnt;
    }
};
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
         int m = grid.size();
        int n = grid[0].size();

        int vis[m][n];
        // {{r,c},t}

        queue< pair<pair<int,int>, int> > q;
        int t = 0;
        int fresh = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                {
                    vis[i][j] = 2;
                    q.push({{i,j},0});
                }

                else
                {
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        // {{r,c},t}
        int ts = 0;
        int delrow[] = {1,0,-1,0};
        int delcol[] = {0,1,0,-1};
        int gotrotten = 0;

        while(!q.empty())
        {
            int r = q.front().first.first;
            int c = q.front().first.second;
            t = q.front().second;
            ts = max(ts,t);
            q.pop();
            for(int i = 0; i < 4; i++)
            {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow < m && nrow >=0 && ncol < n && ncol >= 0 && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1)
                {
                    gotrotten++;
                    q.push({{ nrow,ncol},t+1 });
                    vis[nrow][ncol] = 2;
                }
            }
        }

        if(fresh != gotrotten)
        {
            return -1;
        }

        return ts;

    }
};
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }

        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            mat[u][v] = w;
            mat[v][u] = w;
        }

        for(int k = 0; k < n; k++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE)
                    {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        int city = 0;
        int maxo = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++)
            {
                int cnt = 0;

                for(int j = 0; j < n; j++)
                {
                   if(i != j && mat[i][j] != Integer.MAX_VALUE && mat[i][j] <= distanceThreshold)
                   {
                        cnt++;
                   }
                }

                if(maxo >= cnt)
                {
                    city = i;
                    maxo = cnt;
                }
            }

            return city;

        
    }
}
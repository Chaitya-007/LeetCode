class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // In you want to take ai then you must take bi first => a -> b
        List<List<Integer>> adj = new ArrayList<>();
        int v = numCourses;

        for(int i = 0; i < v; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj.get(b).add(a);
        }

        int[] indegree = new int[v];
        
        for(int i = 0; i < adj.size(); i++)
        {
            for(Integer adjNode : adj.get(i))
            {
                indegree[adjNode] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty())
        {
            int node = q.peek();
            cnt++;
            q.poll();

            for(Integer adjNode : adj.get(node))
            {
                if(indegree[adjNode] > 0)
                {
                    indegree[adjNode] -= 1;
                    if(indegree[adjNode] == 0)
                    {
                        q.offer(adjNode);
                    }
                }
            }

        }

        if(cnt == v) return true;
        return false;
    }
}
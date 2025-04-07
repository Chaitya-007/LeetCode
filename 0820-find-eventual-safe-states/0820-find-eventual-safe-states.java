class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
     List<List<Integer>> adj  = new ArrayList<>(); 

     for(int i = 0; i < v; i++)
     {
        adj.add(new ArrayList<>());
     }

     for(int i = 0; i < graph.length; i++)
     {
        for(int j = 0; j < graph[i].length; j++)
        {
            adj.get(graph[i][j]).add(i);
        }
     }

     int[] indegree = new int[v];

     for(int i = 0; i < v; i++)
     {
        for(Integer adjNode : adj.get(i))
        {
            indegree[adjNode] += 1;
        }
     }

     Queue<Integer> q = new LinkedList<>();
     List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < v; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.peek();
            ans.add(node);
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


        Collections.sort(ans);
        return ans;

    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int queries_size = queries.length;
      int[] result = new int[queries_size];
        List<List<Integer>> adj_list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj_list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adj_list.get(i).add(i + 1);
        }

        class BFSclass {
            int bfs_function() {
                int[] dist_cities = new int[n];
                Arrays.fill(dist_cities, n);
                Queue<Integer> q = new LinkedList<>();
                dist_cities[0] = 0;
                q.add(0);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj_list.get(u)) {
                        if (dist_cities[v] > dist_cities[u] + 1) {
                            dist_cities[v] = dist_cities[u] + 1;
                            q.add(v);
                        }
                    }
                }
                return dist_cities[n - 1];
            }
        }

        BFSclass traverseal = new BFSclass();

        for (int i = 0; i < queries_size; i++) {
            int[] e = queries[i];
            adj_list.get(e[0]).add(e[1]);
            result[i] = traverseal.bfs_function();
        }

        return result;   
    }
}
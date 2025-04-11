class Pair
{
    int v;
    int w;

    public Pair(int v,int w)
    {
        this.v = v;
        this.w = w;
    }

    public int getV()
    {
        return v;
    }

    public int getW()
    {
        return w;
    }
}

class DisNode
{
    long dis;
    int node;

    public DisNode(long dis, int node)
    {
        this.dis = dis;
        this.node = node;
    }

    public long getDis()
    {
        return dis;
    }

    public int getNode()
    {
        return node;
    }
}


class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = (int)1e9 + 7;
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        Comparator<DisNode> cmp = (p,q) ->
        {
            return Long.compare(p.getDis(),q.getDis());
        };

        PriorityQueue<DisNode> pq = new PriorityQueue<>(cmp);
        pq.offer(new DisNode(0,0));

        long[] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        while(!pq.isEmpty())
        {
            DisNode p = pq.poll();
            long distance = p.getDis();
            int node = p.getNode();

            for(Pair adjNode : adj.get(node))
            {
                int adjv = adjNode.getV();
                int edgeWt = adjNode.getW();

                if(distance + edgeWt < dis[adjv])
                {
                    dis[adjv] = distance + (long)edgeWt;
                    ways[adjv] = ways[node];
                    pq.offer(new DisNode(dis[adjv],adjv));
                }
                else if(distance + edgeWt == dis[adjv])
                {
                    ways[adjv] = (ways[adjv] + ways[node])%mod;
                }
            }
        }

        return ways[n-1]%mod;
    }
}
class DisNode
{
    int dis;
    int node;

    public DisNode(int d,int n)
    {
        this.dis = d;
        this.node = n;
    }

    public int getDis()
    {
        return dis;
    }

    public int getNode()
    {
        return node;
    }
}

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


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }

        Comparator<DisNode> cmp = (p,q) ->
        {
            return Integer.compare(p.getDis(),q.getDis());
        };

        PriorityQueue<DisNode> pq = new PriorityQueue<>(cmp);
        pq.offer(new DisNode(0,k));

        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;

        while(!pq.isEmpty())
        {
            DisNode p = pq.poll();
            int node = p.getNode();
            int distance = p.getDis();

            for(Pair adjNode : adj.get(node))
            {
                int adjv = adjNode.getV();
                int edgwt = adjNode.getW();

                if(distance + edgwt < dis[adjv])
                {
                    dis[adjv] = distance + edgwt;
                    pq.offer(new DisNode(dis[adjv],adjv));
                }
            }
        }

        int maxo = 0;
        for(int i = 1; i <= n; i++)
        {
            maxo = Math.max(dis[i],maxo);
        }

        return maxo == Integer.MAX_VALUE ? -1 : maxo;
    }
}
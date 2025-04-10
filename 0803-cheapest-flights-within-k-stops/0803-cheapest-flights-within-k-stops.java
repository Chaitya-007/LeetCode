
class DisNodeK
{
    int dis;
    int node;
    int k;

    public DisNodeK(int k,int n,int d)
    {
        this.dis = d;
        this.node = n;
        this.k = k;
    }

    public int getDis()
    {
        return dis;
    }

    public int getNode()
    {
        return node;
    }

    public int getK()
    {
        return k;
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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Comparator<DisNodeK> cmp = (p,q) ->
        {
            return Integer.compare(p.getDis(),q.getDis());
        };

        // PriorityQueue<DisNodeK> pq = new PriorityQueue<>(cmp);
        Queue<DisNodeK> q = new LinkedList<>();
        q.offer(new DisNodeK(0,src,0));

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;

        while(!q.isEmpty())
        {
            DisNodeK p = q.poll();
            int node = p.getNode();
            int distance = p.getDis();
            int newK = p.getK();

            if( newK > k)
            {
                continue;
            }

            for(Pair adjNode : adj.get(node))
            {
                int adjv = adjNode.getV();
                int edgeWt = adjNode.getW();
                 
                    if(distance + edgeWt < dis[adjv])
                    {
                        dis[adjv] = distance + edgeWt;
                        q.offer(new DisNodeK(newK+1,adjv,dis[adjv]));
                    }
                

            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
        
    }
}
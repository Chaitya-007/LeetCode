class Disjoint
{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n)
    {
        for(int i = 0; i < n; i++)
        {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node)
    {
        if(node == parent.get(node))
        {
            return node;
        }

        int updPar = findUpar(parent.get(node));
        parent.set(node,updPar);
        return updPar;
    }

    public void unionBySize(int u,int v)
    {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}


class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for(int i = 0; i < stones.length; i++)
        {
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        Disjoint ds = new Disjoint(maxRow +  1 + maxCol + 1);

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < stones.length; i++)
        {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            ds.unionBySize(row,col);

            set.add(row);
            set.add(col);
        }

        int cnt = 0;

        for(Integer node : set)
        {
            if(ds.findUpar(node) == node)
            {
                cnt++;
            }
        }

        int n = stones.length;

        return n - cnt;
    }
}
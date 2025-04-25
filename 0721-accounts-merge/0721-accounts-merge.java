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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        Disjoint ds = new Disjoint(n);

        HashMap<String, Integer> mails = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < accounts.get(i).size(); j++)
            {
                String str = accounts.get(i).get(j);
                if(mails.containsKey(str))
                {
                    ds.unionBySize(mails.get(str),i);
                }
                else
                {
                    mails.put(str,i);
                }
            }
        }

        List<List<String>> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();


        for(int i = 0; i < n; i++)
        {
            temp.add(new ArrayList<>());
        }

        for(Map.Entry<String, Integer> e : mails.entrySet())
        {
            String key = e.getKey();
            int value = e.getValue();

            int ulp = ds.findUpar(value);

            temp.get(ulp).add(key);
        }

        for(int i = 0; i < n; i++)
        {
            if(temp.get(i).size() == 0) continue;

            Collections.sort(temp.get(i));

            List<String> list = new ArrayList<>();

            list.add(accounts.get(i).get(0));

            for(String str : temp.get(i))
            {
                list.add(str);
            }
            ans.add(list);
        }

        return ans;
    }
}
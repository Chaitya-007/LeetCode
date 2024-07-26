class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(int i = 0; i < arr.length; i++)
        {
           
                String str = arr[i];
                if(map.containsKey(str))
                {
                    map.put(str,map.get(str) + 1);
                }
                else
                {
                map.put(str,1);

                }

        }

        List<String> list = new ArrayList<String>();

        for(String key : map.keySet())
        {
            if(map.get(key) > 1)
            {
                list.add(key);
            }
        }

        for(String num : list)
        {
            map.remove(num);
        }

        if(map.size() < k)
        {
            return "";
        }

        System.out.println(map);

        String res = "";
        int cnt = 0;
        for(int i = 0; i < arr.length ; i++)
        {
            String str = arr[i];
            if(map.containsKey(str) && ++cnt == k)
            {
                res += str;
            }
        }

        return res;
    }
}
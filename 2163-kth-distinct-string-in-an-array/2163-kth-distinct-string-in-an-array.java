class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Boolean> map = new LinkedHashMap<String,Boolean>();

        for(String str : arr)
        {
            map.put(str, !map.containsKey(str));
        }

        int i = 0;
        for(String str : arr)
        {
            if(map.get(str) && ++i == k)
            {
                return str;
            }
        }

        return "";
    }
}
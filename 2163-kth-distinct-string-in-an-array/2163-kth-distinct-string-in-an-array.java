class Solution {
    public String kthDistinct(String[] arr, int k) {

        Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();

        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], false);
            }
            else
            {
                map.put(arr[i],true);
            }
        }

        for(Map.Entry<String, Boolean> e : map.entrySet())
        {
            if(e.getValue())
            {
                k--;
            }
            if(k==0)
            {
                return e.getKey();
            }
        }

        return "";
        
    }
}
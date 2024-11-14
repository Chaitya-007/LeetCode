class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();
     for(int val : target)
     {
        map.put(val, map.getOrDefault(val,0) + 1);
     }   

     for(int val : arr)
     {
        if(map.containsKey(val))
        {
                map.put(val, map.get(val) - 1);
            if(map.get(val) == 0)
            {
                map.remove(val);
            }
        
        }
        else
        {
            return false;
        }
     }

     if(map.size() == 0)
     {
        return true;
     }

     return false;
    }
}
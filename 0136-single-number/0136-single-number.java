class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();

        for(int arrayElement : nums)
        {
            if(hm.containsKey(arrayElement))
            {
                hm.put(arrayElement,hm.get(arrayElement)  + 1);
            }
            else
            {
                hm.put(arrayElement,1);
            }
        }


        for(Map.Entry<Integer, Integer> e : hm.entrySet())
        {
            if(e.getValue() == 1)
            {
                return e.getKey();
            }
        }

        return -1;
    }
}
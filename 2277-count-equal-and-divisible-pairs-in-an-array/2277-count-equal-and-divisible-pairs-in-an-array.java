class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer,ArrayList<Integer>> map= new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.get(nums[i]).add(i);
            }
            else
            {
                map.put(nums[i],new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }
        for(Integer key:map.keySet())
        {
            Map<Integer,Integer> gcds=new HashMap<>();
            for(Integer it:map.get(key))
            {
                int gcdi=gcd(it,k);
                for(Integer gcdj:gcds.keySet())
                {
                    res+= (gcdi*gcdj %k!=0) ?0: gcds.get(gcdj);
                }
                gcds.put(gcdi,gcds.getOrDefault(gcdi,0)+1);
            }
        }
        return res;
    }
    static int gcd(int a, int b)
	{
	    if (b == 0)
	        return a;
	    return gcd(b, a % b);
	     
	}
}
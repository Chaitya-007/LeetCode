class Solution {
    public long maximumProduct(int[] nums, int m) {
        long product = Long.MIN_VALUE;
        int n = nums.length;

        // for(int i = 0; i < n; i++)
        //     {
        //         for(int j = i + m - 1; j < n; j++)
        //             {
        //                 long val = (long)nums[i]* (long)nums[j];
        //                 product = Math.max(product,val);
        //             }
        //     }

        // return product;



        TreeMap<Integer,Integer> nextMap = new TreeMap<>();

        for(int i = m - 1; i < n; i++)
            {
                nextMap.put(nums[i], nextMap.getOrDefault(nums[i],0) + 1);
            }

        // TreeMap<Integer,Integer> prevMap = new TreeMap<>();
        int prevMax = Integer.MIN_VALUE;
        int prevMin = Integer.MAX_VALUE;

        for(int i = 0; i <= (n - m); i++)
            {
                prevMax = Math.max(nums[i],prevMax);
                prevMin = Math.min(nums[i],prevMin);

                Map.Entry<Integer,Integer> first = nextMap.firstEntry();
                Map.Entry<Integer,Integer> last = nextMap.lastEntry();

                Integer nextMin = first.getKey();
                Integer nextMax = last.getKey();

                Long valMax = (long)prevMax * (long)nextMax;
                Long valMin = (long)prevMin * (long)nextMin;

                product = Math.max(valMax,product);
                product = Math.max(valMin,product);

                nextMap.put(nums[i + m - 1], nextMap.get(nums[i + m - 1]) - 1);
                
                if(nextMap.get(nums[i + m - 1]) == 0)
                {
                    nextMap.remove(nums[i + m - 1]);
                }
            }

        return product;
        
    }
}
class Solution {

    public boolean isPrime(int n)
    {
        int factor = 0;

        for(int i = 1; i <= Math.sqrt(n); i++)
            {
                if(n%i == 0)
                {
                    factor++;
                    if(n/i != i)
                    {
                        factor++;
                    }
                }

                if(factor > 2) return false;
            }

        if(factor == 2) return true;

        return false;
    }
    
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : nums)
            {
                map.put(val, map.getOrDefault(val,0) + 1);
            }

        for(Integer freq : map.values())
            {
                if(isPrime(freq)) return true;
            }

        return false;
    }
}
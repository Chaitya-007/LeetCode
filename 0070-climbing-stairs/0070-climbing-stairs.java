class Solution {

    // Recursive Solution => TLE
    // public int DpOnStairs(int ind)
    // {
    //    if(ind == 0 || ind == 1)
    //    {
    //     return 1;
    //    }

    //    return (DpOnStairs(ind - 1) + DpOnStairs(ind - 2));
    // }

    // Memoizattion
    public int memo(int ind, Map<Integer,Integer> map)
    {
        if(ind == 0 || ind == 1)
        {
            return 1;
        }

        if(!map.containsKey(ind))
        {
            map.put(ind,memo(ind - 1,map) + memo(ind - 2,map));
        }

        return map.get(ind);
    }

    public int climbStairs(int n) {
        // Recusrive Solution
    //  int result = DpOnStairs(n);
    //  return result;   

    // Memoization
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    int result = memo(n,map);
    return result;
    }
}
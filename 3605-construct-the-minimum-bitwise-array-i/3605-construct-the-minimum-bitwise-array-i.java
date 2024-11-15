class Solution {



    public int[] minBitwiseArray(List<Integer> nums) {

        int[] arr = new int[nums.size()];
        int ind = 0;

        for(Integer val : nums)
        {
            if(val%2 == 0)
            {
                arr[ind] = -1;
                ind++;
            }
            else
            {
                for(int i = 0; i < val; i++)
                {
                    if(((i) | (i+1)) == (val))
                    {
                        arr[ind] = (i);
                        ind++;
                        break;
                    }
                }
            }
        }

        return arr;
    }
}
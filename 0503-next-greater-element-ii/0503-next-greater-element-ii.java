class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[2*(nums.length)];
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < nums.length; i++)
        {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }

        for(int i = n - 1; i >= 0; i--)
        {
            int nxtGrt = -1;

            for(int j = i + 1; j < (2*n); j++)
            {
                if(arr[i] < arr[j])
                {
                    nxtGrt = arr[j];
                    break;
                }
            }

            res[i] = nxtGrt;
        }

        return res;
    }
}
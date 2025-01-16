class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int cnt = 0;
        int element = -1;

        for(int i = 0; i < n; i++)
        {
            if(cnt == 0)
            {
                element = nums[i];
            }

            if(element == nums[i])
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }

        return element;
    }
}
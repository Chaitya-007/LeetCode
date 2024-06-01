// https://youtu.be/D6pHZWaafUs?feature=shared

class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {

        // Remember to sort
        // sort(nums.begin(), nums.end());
        // int start = 0;
        // int end = 0;
        // long sum = 0;
        // int n = nums.size();
        // int res = 1;

        // while (end < n) {
        //     // Observe carefully that the end gets incremented after adding
        //     // nums[end] to sum
        //     sum += nums[end++];

        //     if ((sum + k) < ((long)nums[end - 1]) * (end - start)) {
        //         sum -= nums[start++];
        //     }

        //     res = max(res, (end - start));
        // }

        // return res;

        sort(nums.begin(),nums.end());
        int start = 0;
        int end = 0;
        int res = 1;
        int n = nums.size();

        long sum = 0;

        while(end < n)
        {
            sum += nums[end++];

            if(sum + k < (long) nums[end-1]*(end - start))
            {
                sum -= nums[start++];
            }

            res = max(res,end-start);
        }
        
        return res;
    }
};
class Solution {
public:

    int computesum(vector<int>& nums, int threshold, int val)
    {
        // return 1 => sum <= threshold
        // return 0 => sum > threshold
        long long sum = 0ll;
        int n = nums.size();
        for(int i = 0; i < n; i++)
        {
            sum += ceil((double)nums[i]/(double)val);
            if(sum > threshold)
            {
                return 0;
            }
        }

        return 1;
    }

    int smallestDivisor(vector<int>& nums, int threshold) {
        long long low = 1ll;
        long long high = *max_element(nums.begin(),nums.end());
        long long ans = 0ll;

        while(low <= high)
        {
            long long mid = low + (high - low)/2;
            int sumval = computesum(nums, threshold, mid);

            if(sumval == 1)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans; // or return low
    }
};
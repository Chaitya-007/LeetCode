class Solution {
public:
    int maxSubArray(vector<int>& nums) {


        int sum = 0;
        int maxo = INT_MIN;

        for(int i = 0; i < nums.size(); i++)
        {
            sum += nums[i];
            maxo = max(maxo,sum);
            if(sum < 0)
            {
                sum = 0;
            }
        }

        return maxo;

        // Brute Force
        // long long int sum = 0;
        // long long int maxsum = INT_MIN;
        // int n = nums.size();

        // for(int i = 0; i < n; i++)
        // {
        //     sum = 0;
        //     for(int j = i; j < n; j++)
        //     {
        //         sum += nums[j];

        //         if(sum > maxsum)
        //         {
        //             maxsum = sum;
        //         }
        //     }
        // }

        // return maxsum;

        // Kadane's algorithm
        // long long int sum = 0;
        // long long int maxi = INT_MIN;

        // for(int i = 0; i < nums.size(); i++)
        // {
        //    sum += nums[i];
        //     maxi = max(maxi,sum);
        //     if(sum < 0)
        //     {
        //         sum = 0;
        //     }

        // }

        // return maxi;

    

    }
};
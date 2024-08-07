class Solution {
public:

    bool compute(int n, int sum, vector<int> arr)
    {
        vector<bool> prev(sum + 1,0);
        vector<bool> curr(sum + 1,0);

        prev[0] = true;
        curr[0] = true;

        if(arr[0] <= sum)
        {
            prev[arr[0]] = true;
        }

        for(int ind = 1; ind < n; ind++)
        {
            for(int target = 1; target <= sum ; target++)
            {
                bool notTake = prev[target];
                bool take = false;
                if(arr[ind] <= target)
                {
                    take = prev[target - arr[ind]];
                }

                curr[target] = (notTake | take);
            }

            prev = curr;
        }

        return prev[sum];
    }

    bool canPartition(vector<int>& nums) {

     int n = nums.size(); 
     int totalSum = 0;

    for(int i = 0; i < n; i++)
    {
        totalSum += nums[i];
    }

    if(totalSum%2 == 1)
    {
        return false;
    }

    return compute(n,(totalSum/2),nums);

    }
};
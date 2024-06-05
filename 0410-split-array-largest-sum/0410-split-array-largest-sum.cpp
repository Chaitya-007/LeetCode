class Solution {
public:

    int computeSplits(vector<int>& vec, int k, int capacity)
    {
        int n = vec.size();
        int split = 1;
        int sum = vec.front();

        for(int i = 1; i < n; i++)
        {
            if(sum + vec[i] > capacity)
            {
                split++;
                sum = vec[i];
            }
            else
            {
                sum += vec[i];
            }

            if(split > k)
            {
                return 0;
            }
        }

        return 1;
    }

    int splitArray(vector<int>& nums, int k) {
        int n = nums.size();
        if(k > n)
        {
            return -1;
        }

        int low = *max_element(nums.begin(),nums.end());
        int high = accumulate(nums.begin(), nums.end(), 0);
        int ans = -1;

        // Brute Force
        // T.C -> O(N*N)
        // S.C -> O(1)

        // for(int i = low; i <= high; i++)
        // {
        //     if(computeSplits(nums,k,i))
        //     {
        //         return i;
        //     }
        // }

        // return -1;

        // Optimal Solution
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(computeSplits(nums,k,mid))
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        return low; // or return low
    }
};
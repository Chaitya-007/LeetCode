class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        // if(nums.size() == 3)
        // {
        //     int sum = accumulate(nums.begin(),nums.end(),0);
        //     return sum;
        // }

        sort(nums.begin(),nums.end());
        long sum = 0;
        long result = 0;
        int min = INT_MAX;

        for(int i = 0; i < nums.size() - 2; i++)
        {
            if( i != 0 and nums[i] == nums[i-1])
            {
                continue;
            }
           
                
            int l = i + 1;
            int r = nums.size() - 1;
            while(l < r)
            {
                sum = nums[i] + nums[l] + nums[r];
                if(sum == target)
                {
                    result = sum;
                    return result;
                }

                if(abs(target - sum) < min)
                {
                    min = abs(target - sum);
                    result = sum;
                }

                else if(sum > target)
                {
                    r--;
                    while(l<r and nums[r] == nums[r+1])
                {
                    r--;
                }
                }
                else
                {
                    l++;
                while(l<r and nums[l] == nums[l-1])
                {
                    l++;
                }
                }

               

                
                
            }

            
        }
        return result;

    //        

    

    }
};
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        // int cnt = 0;
        // int maxoccur = 0;

        // int n = nums.size();

        // for(int i = 0; i < n; i++)
        // {
        //     if(nums[i] == 1)
        //     {
        //         cnt++;
        //     }
        //     else
        //     {
        //         cnt = 0;
        //     }

        //     maxoccur = max(maxoccur,cnt);
        // }

        // return maxoccur;
















        int n = nums.size();
        int maxcount = 0;
        int cnt = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 1)
            {
                cnt++;
                maxcount = max(maxcount,cnt);
            }
            else
            {
                cnt = 0;
            }

            
        }

        return maxcount;
    }
};
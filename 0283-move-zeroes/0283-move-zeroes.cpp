class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        
        int n = nums.size();
        int i = -1;
        for(int k = 0; k < n; k++)
        {
            if(nums[k] == 0)
            {
                i = k;
                break;
            }
        }

        if(i != -1)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(nums[j] != 0)
                {
                    swap(nums[i],nums[j]);
                    i++;
                }
            }
        }

        // int l = 0;
        // int r = l + 1;
        // int n = nums.size();
        // while(r < n)
        // {
        //     if(nums[l] != 0)
        //     {
        //         l++;
        //         r++;
        //     }
        //     else if(nums[r] != 0)
        //     {
        //         swap(nums[l],nums[r]);
        //         l++;
        //         r++;
        //     }
        //     else
        //     {
        //         r++;
        //     }
        // }

        // ************************************************

        // int n = nums.size();
        // int j = -1;

        // for(int i = 0; i < n; i++)
        // {
        //     if(nums[i] == 0)
        //     {
        //         j = i;
        //         break;
        //     }
        // }

        // if(j != -1)
        // {
        //     for(int i = j+1; i < n; i++)
        //     {
        //         if(nums[i] != 0)
        //         {
        //             swap(nums[i],nums[j]);
        //             j++;
        //         }
        //     }
        // }

    }
};
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {

        vector<vector<int>> ans;
        sort(nums.begin(),nums.end());

        // base case 
        if(nums.size() < 3)
        {
            // There doesn't exists any triplet
            return {};
        }

        if(nums[0] > 0)
        {
            // all elements further will be > 0 
            // that means no negative integers
            // no triple can be formed such that sum = 0
            return {};
        }

        for(int i = 0; i < nums.size(); i++)
        {
            if(i != 0 and nums[i] == nums[i-1]) 
            {
                continue;
            }
                int l = i + 1;
                int r = nums.size() - 1;
                while(l < r)
                {
                    if(nums[i] + nums[l] + nums[r] == 0)
                    {
                        vector<int>vec = {nums[i],nums[l],nums[r]};
                        ans.emplace_back(vec);
                        l++;
                        r--;
                        while(l<r and nums[l] == nums[l-1]){l++;}
                        while(l<r and nums[r] == nums[r+1]){r--;}
                    }
                    
                    else if(nums[i] + nums[l] + nums[r] < 0)
                    {
                        l++;
                    }

                    else
                    {
                        r--;
                    }
                }
        }

    //     sort(ans.begin(),ans.end());
    //    ans.erase(unique(ans.begin(),ans.end()),ans.end());
        return  ans;
        
    }
};
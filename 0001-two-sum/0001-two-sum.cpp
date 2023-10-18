class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // vector<int>v;
        // for(int i = 0; i < nums.size(); i++)
        // {
        //     for(int j = i + 1 ; j < nums.size();j++)
        //     {
        //         if(nums[i] + nums[j] == target)
        //         {
        //             v = {i,j};
        //             break;
        //         }
        //     }
        //     if(!v.empty())
        //     {
        //         break;
        //     }
        // }

        // return v;

        unordered_map<int, int> mp;
        int n = nums.size();

        // two paas hash map
        for(int i = 0; i < n ; i++)
        {
            mp[nums[i]] = i;
        }

        for(int i = 0; i < n ; i++)
        {
            int complement = target - nums[i];
            if(mp.count(complement) and mp[complement] != i)
            {
                return {i,mp[complement]};
            }
        }

        return {};
        
    }
};
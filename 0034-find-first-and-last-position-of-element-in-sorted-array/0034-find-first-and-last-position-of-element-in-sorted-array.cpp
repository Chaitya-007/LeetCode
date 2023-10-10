class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>v;

        if(nums.empty())
        {
            v.emplace_back(-1);
            v.emplace_back(-1);
            return v;
        }

        for(int i = 0; i < nums.size() ; i++)
        {
            if(nums[i]>target)
            {
                break;
            }

            if(nums[i] == target)
            {
                v.emplace_back(i);
            }
        }

        if(v.empty())
        {
            v.emplace_back(-1);
            v.emplace_back(-1);
            return v;
        }

        vector<int>res;
        res.emplace_back(v[0]);
        int last = v[v.size() - 1];
        res.emplace_back(last);
        return res;
    }
};
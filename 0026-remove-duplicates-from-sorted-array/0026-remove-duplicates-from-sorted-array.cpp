class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        set<int>s(nums.begin(),nums.end());

        nums = {s.begin(),s.end()};
        int res = s.size();
        return res;

        
    }
};
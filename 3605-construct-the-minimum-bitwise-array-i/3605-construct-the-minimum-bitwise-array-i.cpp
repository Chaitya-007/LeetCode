class Solution {
public:
       vector<int> minBitwiseArray(vector<int>& nums) {
        vector<int> ans;
        for (int n : nums) {
            int bit = 0;
            while (n & (1 << bit))                              // Find the first 0 bit
                bit++;
            ans.push_back(n > 2 ? n ^ (1 << (bit - 1)) : -1);   // Flip the previous 1 bit
        }
        return ans;
    }
};
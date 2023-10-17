class Solution {
public:
    vector<int> lastVisitedIntegers(vector<string>& words)
    {
        
        vector<int> nums;
        vector<int> ans;
        int count = 0;

        for(int i = 0; i < words.size(); i++)
        {
            if(words[i] != "prev")
            {
                int num = stoi(words[i]);
                nums.emplace_back(num);
                count = 0;
            }
            else
            {
                count++;
                if(count > nums.size())
                {
                    ans.emplace_back(-1);
                }
                else
                {
                    ans.emplace_back(nums[nums.size() - count]);
                }
            }
        }

        return ans;
    }
};
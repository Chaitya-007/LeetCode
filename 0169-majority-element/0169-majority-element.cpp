class Solution {
public:
    int majorityElement(vector<int>& nums) {
        // Optimal 
        // Moone's voting algorithm
        int cnt = 0;
        int element;

        for(int i = 0; i < nums.size(); i++)
        {
            if(cnt == 0)
            {
                element = nums[i];
            }

            if(element == nums[i])
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }
        if(cnt)
        {
            return element;
        }

        return -1;

        // Better
        // T.C => O(nlogn) + O(n)
        // S.C => O(n)
        // unordered_map<int,int> umap;

        // for(int i = 0; i < nums.size(); i++)
        // {
        //     umap[nums[i]]++;
        // }

        // int freq = (nums.size()/2);

        // for(auto itr : umap)
        // {
        //     if(itr.second > freq)
        //     {
        //         return itr.first;
        //     }
        // }

        // return -1;

        // Brute Force
        // T.C => O(n^2)
        // S.C => O(1)
        // for(int i = 0; i < nums.size(); i++)
        // {
        //     int cnt = 0;
        //     for(int j = 0; j < nums.size(); j++)
        //     {
        //         if(nums[i] == nums[j])
        //         {
        //             cnt++;
        //         }
        //     }

        //     if(cnt > (nums.size()/2))
        //     {
        //         return nums[i];
        //     }
        // }

        // return -1;


    }
};
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // set<int>s(nums.begin(),nums.end());

        // nums = {s.begin(),s.end()};
        // int res = s.size();
        // return res;

    //     int l = 0;
    //     int r = 1;
    //     int n = nums.size();
    //     long count = 1;

    //     if(nums.size() == 1)
    //     {
    //         return 1;
    //     }

    //     while(r<n)
    //     {
    //         if(nums[r] == nums[r-1])
    //         {
    //             r++;
    //         }
    //         else
    //         {
    //             count++;
    //             nums[l+1] = nums[r];
    //             l++;
    //             r++;
    //         }
    //     }

    // return count;


    int cnt = 1;
    int l = 0;
    int r = 0;
    int n = nums.size();

    while(r < n)
    {
        if(nums[l] != nums[r])
        {
            cnt++;
            nums[l+1] = nums[r];
            l++;
        }
        r++;
    }

    return cnt;

    // using STL
    // set<int> hashset;
    // for(int i = 0; i < nums.size(); i++)
    // {
    //     hashset.insert(nums[i]);
    // }

    // int k = hashset.size();
    // int i = 0;

    // for(auto itr : hashset)
    // {
    //     nums[i] = itr;
    //     i++;
    // }

    // return k;

        
    }
};
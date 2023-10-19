class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {

        // using set method
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

        // you cannot use this because
        // The error you're encountering is related to the default constructor of unordered_set<vector<int>>. The error message suggests that the default constructor is implicitly deleted because one of its base classes has a deleted default constructor.

// To fix this issue, you can explicitly define the default constructor for unordered_set<vector<int>> before using it. Here's an updated version of your code with the explicit default constructor:

// unordered_set<vector<int>> sec;


struct VectorHash {
    size_t operator()(const std::vector<int>& vec) const {
        size_t seed = vec.size();
        for(auto& i : vec) {
            seed ^= i + 0x9e3779b9 + (seed << 6) + (seed >> 2);
        }
        return seed;
    }
};

unordered_set<vector<int>, VectorHash> sec;


        for(int i = 0; i < nums.size(); i++)
        {
            // if(nums[i] > 0)
            // {
            //     // because all elements after it will be positive
            //     // because of condition that the sum is zero this is used
            //     // or else it wouldn't have been used
            //     // and no triplet can be formed
            //     break;
            // }
            // if(i != 0 and nums[i] == nums[i-1]) 
            // {
            //     continue;
            // }
                int l = i + 1;
                int r = nums.size() - 1;
                while(l < r)
                {
                    if(nums[i] + nums[l] + nums[r] == 0)
                    {
                        vector<int>vec = {nums[i],nums[l],nums[r]};
                        sort(vec.begin(),vec.end());
                        sec.insert(vec);
                        // ans.emplace_back(vec);
                        l++;
                        r--;
                        // while(l<r and nums[l] == nums[l-1]){l++;}
                        // while(l<r and nums[r] == nums[r+1]){r--;}
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

        ans = {sec.begin(),sec.end()};
    //     sort(ans.begin(),ans.end());
    //    ans.erase(unique(ans.begin(),ans.end()),ans.end());
        return  ans;

        // using two pointer
        //  vector<vector<int>> ans;
        // sort(nums.begin(),nums.end());

        // // base case 
        // if(nums.size() < 3)
        // {
        //     // There doesn't exists any triplet
        //     return {};
        // }

        // if(nums[0] > 0)
        // {
        //     // all elements further will be > 0 
        //     // that means no negative integers
        //     // no triple can be formed such that sum = 0
        //     return {};
        // }


        // for(int i = 0; i < nums.size(); i++)
        // {
        //     // if(nums[i] > 0)
        //     // {
        //     //     // because all elements after it will be positive
        //     //     // because of condition that the sum is zero this is used
        //     //     // or else it wouldn't have been used
        //     //     // and no triplet can be formed
        //     //     break;
        //     // }
        //     // if(i != 0 and nums[i] == nums[i-1]) 
        //     // {
        //     //     continue;
        //     // }
        //         int l = i + 1;
        //         int r = nums.size() - 1;
        //         while(l < r)
        //         {
        //             if(nums[i] + nums[l] + nums[r] == 0)
        //             {
        //                 vector<int>vec = {nums[i],nums[l],nums[r]};
        //                 sort(vec.begin(),vec.end());
        //                 s.insert(vec);
        //                 // ans.emplace_back(vec);
        //                 l++;
        //                 r--;
        //                 // while(l<r and nums[l] == nums[l-1]){l++;}
        //                 // while(l<r and nums[r] == nums[r+1]){r--;}
        //             }
                    
        //             else if(nums[i] + nums[l] + nums[r] < 0)
        //             {
        //                 l++;
        //             }

        //             else
        //             {
        //                 r--;
        //             }
        //         }
        // }

        // return  ans;



        
    }
};
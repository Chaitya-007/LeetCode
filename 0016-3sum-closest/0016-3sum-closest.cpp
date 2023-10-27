class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        // if(nums.size() == 3)
        // {
        //     int sum = accumulate(nums.begin(),nums.end(),0);
        //     return sum;
        // }

        // sort(nums.begin(),nums.end());
        // long sum = 0;
        // int flag = 1;
        // long result = 0;

        // for(int i = 0; i < nums.size(); i++)
        // {
        //     if( i != 0 and nums[i] == nums[i-1])
        //     {
        //         continue;
        //     }
        //    
        //         
        //     int l = i + 1;
        //     int r = nums.size() - 1;;
        //     while(l < r)
        //     {
        //         sum = nums[i] + nums[l] + nums[r];
        //         if(sum == target)
        //         {
        //             result = sum;
        //             return result;
        //         }
        //         else if(sum > target)
        //         {
        //             if(flag == 1)
        //             {
        //                 result = sum;
        //                 flag = 2;
        //             }
        //         }
        //         r++;
        //         while(r < nums.size() and nums[r] == nums[r-1])
        //         {
        //             r++;
        //         }
        //     }

        //     
        // }
        // return result;

    //         if(nums.size() < 3) return 0;
    // int closest = nums[0]+nums[1]+nums[2];
    // sort(nums.begin(), nums.end());
    // for(int first = 0 ; first < nums.size()-2 ; ++first) {
    //     if(first > 0 && nums[first] == nums[first-1]) continue;
    //     int second = first+1;
    //     int third = nums.size()-1;            
    //     while(second < third) {
    //         int curSum = nums[first]+nums[second]+nums[third];
    //         if(curSum == target) return curSum;
    //         if(abs(target-curSum)<abs(target-closest)) {
    //             closest = curSum;
    //         }
    //         if(curSum > target) {
    //             --third;
    //         } else {
    //             ++second;
    //         }
    //     }
    // }
    // return closest;

    sort(nums.begin(),nums.end());
        int n=nums.size(),ans;
        int min=INT_MAX;
        for(int i=0;i<n-2;i++){
               int l=i+1, r= n-1;
               while(l<r){
                   int sum =nums[i]+nums[l]+nums[r];
                   if(abs(sum-target)<min){  // updating the sum if sum  so far. is closest to target
                      min=abs(sum-target);
                      ans=sum;
                   }
                   if(sum<target) l++;        //
                   else if(sum>target)r--;
                   else {
                       ans=sum;  // we have sum equal to target which is closest so no need to check further 
                       i=n-2;  // for breaking the outer for loop
                       break;  // for breaking current while loop
                   }
               }
        }
        return ans;

    }
};
class Solution {
public:
    int findKOr(vector<int>& nums, int k)
    {
        // if(k == nums.size())
        // {
        //     int ans = nums[0];
        //     for(int i = 1; i < nums.size(); i++)
        //     {
        //         ans = (ans & nums[i]);
        //     }
        //     return ans;
        // }
        
        // if(k == 1)
        // {
        //     int ans = nums[0];
        //     for(int i = 1; i < nums.size(); i++)
        //     {
        //         ans = (ans | nums[i]);
        //     }
        //     return ans;
        // }
        
        // int n = nums.size();
        // vector<int> vec;
        // int i = 0;
        // int count = 0;
        //  int result = 0;
        // while(i < n)
        // {
        //     count = 0;
        //     int twopower = pow(2,i);
        //     cout<<twopower<<"\n";
        //     for(int j = 0; j < nums.size(); j++)
        //     {
        //         if ( (twopower & nums[j]) == twopower )
        //         {
        //             cout<<nums[j]<<" ";
        //             count++;
        //         }
        //     }
        //     cout<<"\n";
        //     if(count >= k)
        //     {
        //         result += (twopower);
        //         cout<<twopower<<"\n";
        //         cout<<"result = "<<result<<"\n";
        //     }
        //     i++;
        // }
        
       
        // // for(int k = 0; k < vec.size(); k++)
        // // {
        // //     int twopower = pow(2,vec[k]);
        // //     result += (twopower);
        // // }
        // return result;

        int sum=0;
        for(int i=0;i<32;i++){
            int c=0;
            for(int val : nums){
                if(val & (1<<i)) c++;
            }
            if(c >= k) sum += pow(2,i);
        }
        return sum;
    }
};
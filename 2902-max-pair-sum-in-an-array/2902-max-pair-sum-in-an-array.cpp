int max_of_num(int x)
{
    vector<int>v2;
    int rem;
    while(x>0)
    {
        rem = x%10;
        x = x/10;
        v2.emplace_back(rem);
    }
    sort(v2.begin(),v2.end());
    return v2.back();
}


class Solution {
public:
    int maxSum(vector<int>& nums) {
        vector<int>v;
        vector<int>v1;
        int maxo;
        int flag = 1;

        for(int i = 0 ; i < nums.size(); i++)
        {
            maxo = max_of_num(nums[i]);
            v1.emplace_back(maxo);
        }


        for(int i = 0 ; i < v1.size(); i++)
        {
            for(int j = i + 1; j < v1.size(); j++)
            {
                if(v1[i] == v1[j])
                {
                    flag = 2;
                    int sum = nums[i] + nums[j];
                    v.emplace_back(sum);
                }
            }
        }
        
        
        if(flag == 1)
        {
            return -1;
        }

        sort(v.begin(),v.end());
        for(int i = 0 ; i < v.size(); i++)
        {
            cout<<v[i]<<" ";
        }

        return v.back();
    }
};
class Solution {
public:

    int adjacentFlower(vector<int>& vec, int m, int k, long long mid )
    {
        int n = vec.size();
        vector<int> copy(n,0);
         int cnt = 0;
        int pair = 0;

        // for(int i = 0 ; i < n; i++)
        // {
        //     if(vec[i] <= mid)
        //     {
        //         copy[i] = 1;
        //     }
        // }

       

        for(int i = 0; i < n; i++)
        {
            if(vec[i] <= mid)
            {
                cnt++;
            }
            else
            {
                cnt = 0;
            }

            if(cnt == k)
            {
                pair++;
                cnt = 0;
            }

            if(pair >= m)
            {
                return 1;
            }
        }

        return 0;
        
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        long long low = *min_element(bloomDay.begin(),bloomDay.end());
        long long high = *max_element(bloomDay.begin(),bloomDay.end());
        int n = bloomDay.size();

        if(k > n/m) // very essential to prevent overflow
        {
            return -1;
        }

        long long ans = 0ll;

        while(low <= high)
        {
            long long mid = low + (high - low)/2;
            long long possible = adjacentFlower(bloomDay,m,k,mid);

            if(possible == 1)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans; // return low;
    }
};
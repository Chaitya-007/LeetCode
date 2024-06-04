class Solution {
public:

    long long func(vector<int>& vec, int mid, int h)
    {
        // return 0 => sum > h
        // return 1 => sum <= h

        long long sum = 0ll;
        for(int i = 0; i < vec.size(); i++)
        {
            sum += ceil((double)vec[i]/(double)mid);

            if(sum > h)
            {
                return 0;
            }
        }

       return 1;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();

        // O(N*N)
        // int maxo = *max_element(piles.begin(),piles.end());

        // for(long long i = 1; i <= maxo; i++)
        // {
        //     long long timereq = func(piles,i);

        //     if(timereq <= h)
        //     {
        //         return i;
        //     }
        // }

        // return 0;

        long long maxo = *max_element(piles.begin(),piles.end());
        long long low = 1ll;
        long long high = maxo;
        long long ans = 0ll;

        while(low <= high)
        {
            long long mid = low + (high - low)/2;
            long long timereq = func(piles,mid,h);

            if(timereq == 1)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        return ans; // or return low
    }
};
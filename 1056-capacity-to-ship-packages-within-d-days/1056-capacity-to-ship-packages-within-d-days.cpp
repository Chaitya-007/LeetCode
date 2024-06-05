class Solution {
public:

    int computedays(vector<int>& weights, int days, int capacity)
    {
        // return 0 => if daycount > days
        // return 1 => if daycount <= days
        int n = weights.size();
        int load = 0;
        int daycount = 1;
        for(int i = 0; i < n; i++)
        {
            if(load + weights[i] > capacity)
            {
                daycount++;
                load = weights[i];
            }
            else
            {
                load += weights[i];
            }

            if(daycount > days)
            {
                return 0;
            }
        }

        return 1;
        // return daycount;
    }

    int shipWithinDays(vector<int>& weights, int days) {
        
        int low = *max_element(weights.begin(),weights.end());
        int high = accumulate(weights.begin(),weights.end(),0);
        int ans = -1;

        // for(int i = low; i <= high; i++)
        // {
        //     int requiredays = computedays(weights, days, i);

        //     if(requiredays <= days)
        //     {
        //         return i;
        //     }
        // }

        // return -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int possible = computedays(weights,days,mid);

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

        return ans; // or  return low
    }
};
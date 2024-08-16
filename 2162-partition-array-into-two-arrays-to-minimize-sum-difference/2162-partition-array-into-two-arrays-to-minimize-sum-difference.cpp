// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/solutions/2721045/best-solution-tabulation-failed-full-explaination-c

class Solution {
public:


    int minimumDifference(vector<int>& arr) {
        int N = arr.size();
        int res = 0;
        int n = N/2;
        int sum = accumulate(arr.begin(),arr.end(),0);

        vector<vector<int>> left(n+1), right(n+1);

        for(int mask = 0; mask < (1<<n) ; ++mask)
        {
            int sz = 0;// gives the number of elements for which the sums will be stored
            int l = 0; // gives the addition of elements from left part
            int r = 0; // gives the addition of elements from right part

            for(int i = 0; i < n; i++)
            {
                if(mask&(1<<i))
                {
                    sz++;
                    l += arr[i];
                    r += arr[n+i];
                }
            }

            left[sz].push_back(l); // stores the all possible sums on left side
            right[sz].push_back(r); // stores the all possible sums on right side
        }

        // sorting the right vector so as to search the closest value of b
        for(int sz = 0; sz <= n; sz++)
        {
            sort(right[sz].begin(),right[sz].end());
        }

        res = min(abs(sum - (2*left[n][0])), abs(sum - 2*(right[n][0])));

        for(int sz = 1; sz < n; sz++) // observe that here we start taking from size
        {
            // here sz = 1 denotes sums formed from single element
            // here sz = 2 deontes sums formed from two element
            // hete sz = 3 deontes sum formed from three element
            for(auto &a : left[sz]) // here left[1] => will contains sums formed from 1 element from left side
            {                       // here left[2] => will contains sums formed from 2 element from right side
                int rsz = (n-sz); // if sz = 1 then rsz = (n - 1) from right i.e => left = sz = 1 
                int b = (sum - (2*a))/2;
                auto &v = right[rsz];
                
                auto itr = lower_bound(v.begin(),v.end(),b);

                if(itr != v.end()) res = min(res,abs(sum - 2*(a + *itr)));
                if(itr != v.begin())
                {
                    auto it = itr;
                    --it;
                    res = min(res,abs(sum - 2*(a + *it)));
                }
            }
        }

        return res;


    }
};
class Solution {
    int[] segTree;
    int[] baskets;
    int n;

    public void build(int ind, int low, int high)
    {
        if(low == high)
        {
            segTree[ind] = baskets[low];
            return;
        }

        int mid = (low + high) >> 1;

        build(2*ind + 1, low, mid);
        build(2*ind + 2, mid + 1, high);

        segTree[ind] = Math.max(segTree[2*ind + 1], segTree[2*ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r)
    {
        
        if(l <= low && high <= r)
        {
            return segTree[ind];
        }

        if(low > r || high < l || low > high) return Integer.MIN_VALUE;

        int mid = (low + high) >> 1;

        int left = query(2*ind + 1, low, mid, l , r);
        int right = query(2*ind + 2, mid + 1, high, l, r);

        return Math.max(left,right);
    }

    public void pointUpdate(int ind, int low, int high, int index, int value)
    {
        if(low == high)
        {
            baskets[index] = value;
            segTree[ind] = value;
            return;
        }

        if(index < low || index > high) return;

        int mid = (low + high) >> 1;

        if(low <= index && index <= mid)
        {
            pointUpdate(2*ind + 1, low, mid, index, value);
        }
        else
        {
            pointUpdate(2*ind + 2, mid + 1, high, index, value);
        }

         segTree[ind] = Math.max(segTree[2*ind + 1],segTree[2*ind + 2]);
    }

    public boolean check(int d, int[] fruits, int ind)
    {
        return query(0,0,n-1,0,d) >= fruits[ind];
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        this.baskets = baskets;
        this.n = fruits.length;
        this.segTree = new int[4*n];
        build(0,0,n-1);
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for(int i = 0; i < n; i++)
        {
            int low = 0;
            int high = n - 1;
            int ans = n;

            while(low <= high)
            {
                int mid = (low + high) >> 1;

                if(check(mid,fruits,i))
                {
                    ans = mid;
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }

            if(ans == n)
            {
                cnt++;
            }
            else
            {
                pointUpdate(0,0,n-1,ans,0);
            }
           
        }

        return cnt;
        
    }
}
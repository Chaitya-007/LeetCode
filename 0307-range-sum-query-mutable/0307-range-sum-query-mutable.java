class NumArray {

    int n;
    int[] seg;
    int[] lazy;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        seg = new int[4*n];
        lazy = new int[4*n];
        build(0,0,n-1);
    }
    
    public void update(int index, int val) {
        updateVal(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return querySumLazy(0,0,n-1,left,right);
    }

    public int querySumLazy(int ind, int low, int high, int l, int r)
    {
        if(lazy[ind] != 0)
        {
            // Increase the value by no. of node * pending increase
            seg[ind] += (high - low + 1) * lazy[ind];

            // Push the pending updates for the next part
            if(low != high)
            {
                lazy[2*ind + 1] += lazy[ind];
                lazy[2*ind + 2] += lazy[ind];
            }

            // make the pending update of initizal as 0
            lazy[ind] = 0;
        }

        if(r < low || high < l || low > high) return 0;

        if(l <= low && high <= r)
        {
            return seg[ind];
        }

        int mid = (low + high) >> 1;

        return querySumLazy(2*ind + 1, low, mid, l, r) + querySumLazy(2*ind + 2, mid + 1, high, l, r);
    }

    public void updateVal(int ind, int low, int high, int index, int val)
    {
        if(low == index && high == index)
        {
            nums[low] = val;
            seg[ind] = val;
            return;
        }

        // If outside we simply return
        if(index < low || index > high) return;

        int mid = (low + high) >> 1;

        updateVal(2*ind + 1, low, mid, index, val);
        updateVal(2*ind + 2, mid + 1, high, index, val);

        seg[ind] = seg[2*ind + 1] + seg[2*ind + 2];
    }

    public void build(int ind, int low, int high)
    {
        if(low == high)
        {
            seg[ind] = nums[low];
            return;
        }

        int mid = (low + high) >> 1;

        build(2*ind+1, low, mid);
        build(2*ind+2, mid + 1, high);

        seg[ind] = seg[2*ind + 1] + seg[2*ind + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
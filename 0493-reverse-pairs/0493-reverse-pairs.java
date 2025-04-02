class Solution {

    public void merge(int low, int mid, int high, int[] arr)
    {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while(left <= mid && right <= high)
        {
            if(arr[left] <= arr[right])
            {
                list.add(arr[left]);
                left++;
            }
            else
            {
                list.add(arr[right]);
                right++;
            }
        }

        while(left <= mid)
        {
            list.add(arr[left]);
            left++;
        }

        while(right <= high)
        {
            list.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++)
        {
            arr[i] = list.get(i - low);
        }
    }

    public int count(int low, int mid, int high, int[] arr)
    {
        int cnt = 0;
        int left = low;
        int right = mid + 1;

        while(left <= mid)
        {
            while(right <= high && (long)arr[left] >(2 *  (long)arr[right])) 
            {
                right++;
            }

            cnt = cnt + (right - (mid + 1));
            left++;
        }

        return cnt;
    }

    public int msort(int low, int high, int[] arr)
    {
        int cnt = 0;
        if(low >= high) return cnt;

        int mid = (low + high) >> 1;
        cnt += msort(low,mid,arr);
        cnt += msort(mid + 1, high, arr);
        cnt += count(low,mid,high,arr);
        merge(low,mid,high,arr);
        return cnt;
    }

    public int reversePairs(int[] nums) {

        int n = nums.length;
        return msort(0, n - 1, nums);
    }
}
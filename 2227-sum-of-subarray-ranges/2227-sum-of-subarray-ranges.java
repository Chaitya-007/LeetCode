class Solution {

    public int[] nse(int[] arr)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = arr.length;
        int[] ind = new int[n];

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() &&  arr[i] <= arr[st.peek()])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ind;
    }

    public int[] psee(int[] arr)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = arr.length;
        int[] ind = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() &&  arr[st.peek()] > arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public int[] nge(int[] arr)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = arr.length;
        int[] ind = new int[n];

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ind;
    }

    public int[] pgee(int[] arr)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = arr.length;
        int[] ind = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() &&  arr[st.peek()] < arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public long sumOfMin(int[] arr)
    {
        final int MOD = (int)(1e9 + 7);
        long total = 0;
        int n = arr.length;
        int[] prev = psee(arr);
        int[] next = nse(arr);

        for(int i = 0; i < n; i++)
        {
           long left = i - prev[i];
            long right = next[i] - i;

           long contribution = (left * right) * arr[i];
            total = (total + contribution);
        }

        return total;
    }

    public long sumOfMax(int[] arr)
    {
        final int MOD = (int)(1e9 + 7);
        long total = 0;
        int n  = arr.length;
        int[] prev = pgee(arr);
        int[] next = nge(arr);

        for(int i = 0; i < n; i++)
        {
            long left = i - prev[i];
            long right = next[i] - i;

           long contribution = (left * right) * arr[i];
            total = (total + contribution);
        }

        return total;
    }

    public long subArrayRanges(int[] nums) {
        return sumOfMax(nums) - sumOfMin(nums);
    }
}
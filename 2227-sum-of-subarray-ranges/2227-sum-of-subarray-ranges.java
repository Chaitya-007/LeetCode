class Solution {

      public int[] nse(int[] arr)
    {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] ind = new int[n];

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
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
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ind = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public long sumSubarrayMins(int[] arr) {

        // T.C -> O(5*N)
        // S.C -> O(2*N) (nse -> Stack, index array) + O(2*N) (psee -> Stack, index array) + O(2*N) (prev,next) = O(6N)
        int n = arr.length;
        int[] prev = psee(arr); // -> O(2*N)
        int[] next = nse(arr); // -> O(2*N)

        long total = 0;

        for(int i = 0; i < n; i++) // -> O(N)
        {
            long left = i - prev[i];
            long right = next[i] - i;

            long contribution =  ( ( (right * left) ) * arr[i] );
            total = (total + contribution);
        }

        return total;
        
    }

    public int[] nge(int[] arr)
    {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ind = new int[n];

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[i] >= arr[st.peek()])
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
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ind = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() &&   arr[st.peek()] < arr[i])
            {
                st.pop();
            }

            ind[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ind;
    }

    public long sumSubarrayMaxs(int[] arr)
    {
        // T.C -> O(10N)
        // S.C -> O(12N)
        int n = arr.length;
        long total = 0;
        int[] prev = pgee(arr);
        int[] next = nge(arr);

        for(int i = 0; i < n; i++)
        {
            long left = i - prev[i];
            long right = next[i] - i;

            long contribution = (left * right * arr[i]);
            total = (total + contribution);
        }

        return total;
    }


    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}
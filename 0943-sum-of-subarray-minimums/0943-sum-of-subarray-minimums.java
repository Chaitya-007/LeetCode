class Solution {

    public int[]  nse(int[] arr)
    {
        int n = arr.length;
        int[] ind = new int[n];

        Stack<Integer> st = new Stack<Integer>();

        for(int i = n - 1; i >= 0; i--)
        {
        while(!st.isEmpty() && arr[st.peek()] >= arr[i])
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
        int[] ind = new int[n];
        Stack<Integer> st = new Stack<Integer>();

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

    public int sumSubarrayMins(int[] arr) {
        
        long total = 0;
        int MOD = (int)(1e9 + 7);
        int n = arr.length;

        int[] next = nse(arr);
        int[] prev = psee(arr); 

        for(int i = 0; i < n; i++)
        {
            long left = i - prev[i];
            long right = next[i] - i;

           long contribution = (left * right % MOD) * arr[i] % MOD;
            total = (total + contribution) % MOD;
        }

        return (int)total;
    }
}
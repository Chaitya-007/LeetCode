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

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        final int MOD = (int)(1e9 + 7);
        int[] prev = psee(arr);
        int[] next = nse(arr);

        long total = 0;

        for(int i = 0; i < n; i++)
        {
            long left = i - prev[i];
            long right = next[i] - i;

            long contribution =  ( ( (right * left)%MOD ) * arr[i] )% MOD;
            total = (total + contribution)%MOD;
        }

        return (int)total;
        
    }
}
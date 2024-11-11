class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for(int val : nums)
        {
            Stack<Integer> st = new Stack<Integer>();
            while(val > 0)
            {
                int rem = val%10;
                val = val/10;
                st.push(rem);
            }

            while(!st.isEmpty())
            {
                list.add(st.peek());
                st.pop();
            }
        }

        int[] ans = new int[list.size()];
        int ind = 0;
        for(Integer val : list)
        {
            ans[ind] = val;
            ind++;
        }

        return ans;
    }
}
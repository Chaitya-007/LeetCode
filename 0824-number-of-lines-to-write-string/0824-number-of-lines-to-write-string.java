class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int sum = 0;

        for(char ch : s.toCharArray())
        {
            int ind = (int)(ch - 'a');

            if(sum + widths[ind] <= 100)
            {
                sum += widths[ind];
            }
            else
            {
                lines++;
                sum = widths[ind];
            }
        }

        int[] ans = new int[2];
        ans[0] = lines;
        ans[1] = sum;

        return ans;
    }
}
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int curr = 0;
        int row = 1;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            int ind = (int) (ch - 'a');
            if(curr + widths[ind] <= 100)
            {
                curr += widths[ind];
            }
            else
            {
                row++;
                curr = widths[ind];
            }
        }

        int[] arr = new int[2];
        arr[0] = row;
        arr[1] = curr;

        return arr;
    }
}
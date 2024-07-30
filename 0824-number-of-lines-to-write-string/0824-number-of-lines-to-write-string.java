class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        
        int sum = 0;
        int cnt = 1;

        for(int i = 0; i < s.length(); i++)
        {
            if(sum + widths[s.charAt(i) - 'a'] <= 100)
            {
                sum += widths[s.charAt(i) - 'a'];
            }
            else
            {
                cnt++;
                sum = widths[s.charAt(i) - 'a'];
            }
        }

        int[] arr = new int[2];
        arr[0] = cnt;
        arr[1] = sum;

        return arr;
    }
}
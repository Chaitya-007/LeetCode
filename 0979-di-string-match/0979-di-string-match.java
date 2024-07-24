class Solution {
    public int[] diStringMatch(String s) {

        // When I == inc++
        // when D == dec--

        int inc = 0;
        int dec = s.length();
        int[] arr = new int[s.length() + 1];
        arr[0] = 0;
        int index = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'I')
            {
                
                arr[i] = inc;
                inc++;
            }
            else
            {
                arr[i] = dec;
                dec--;
            }
        }

        arr[s.length()] = inc; // = dec can also be here

        return arr;
    }
}
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq,0);
        int n = s.length();
        char[] charray = s.toCharArray();

        for(char ch :  charray)
        {
            int ind = (int)(ch - 'a');
            freq[ind] = freq[ind] + 1;
        }

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            int ind = (int)(ch - 'a');
            if(freq[ind] == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
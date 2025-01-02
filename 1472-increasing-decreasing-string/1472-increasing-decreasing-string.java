class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq,0);

        for(char ch : s.toCharArray())
        {
            int ind = (int)(ch - 'a');
            freq[ind] += 1;
        }

        StringBuilder result = new StringBuilder("");

        while(result.length() != s.length())
        {
            for(int i = 0; i < 26; i++)
            {
                if(freq[i] != 0)
                {
                    char ch = (char) (i + 'a');
                    freq[i] -= 1;
                    result.append(ch);
                }
            }

            for(int i = 25; i >= 0; i--)
            {
                if(freq[i] != 0)
                {
                    char ch = (char) (i + 'a');
                    freq[i] -= 1;
                    result.append(ch);
                }
            }
            
        }

        return result.toString();
    }
}
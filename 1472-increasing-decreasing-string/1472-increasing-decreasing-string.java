class Solution {
    public String sortString(String s) {
        
        int[] freq = new int[26];
        Arrays.fill(freq,0);

        for(int i = 0; i < s.length(); i++)
        {
            int ind = (int)(s.charAt(i) - 'a');
            freq[ind] = freq[ind] + 1;
        }

        int n = s.length();

        String str = "";

        while(str.length() < n)
        {
            for(int i = 0; i < 26; i++)
            {
                if(freq[i] > 0)
                {
                    char ch = (char)(i + 'a');
                    freq[i] = freq[i] - 1;
                    str += ch;
                }
            }

            if(str.length() == n)
            {
                break;
            }

            for(int i = 25; i >= 0; i--)
            {
                if(freq[i] > 0)
                {
                    char ch = (char)(i + 'a');
                    freq[i] = freq[i] - 1;
                    str += ch;
                }
            }
        }

        return str;
    }
}
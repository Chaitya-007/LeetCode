class Solution {

    public int getMaxCount(int[] freq)
    {
                int maxFreq = 0; 

        for(int i = 0; i < 26; i++)
        {
            
            maxFreq = Math.max(maxFreq,freq[i]);

        }

        return maxFreq;
    }

    public int getMinCount(int[] freq)
    {
        int minFreq = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] > 0)
            {
            minFreq = Math.min(minFreq,freq[i]);

            }
        }

        return minFreq;

    }

    public int beautySum(String s) {
        
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            int[] freq = new int[26];

            for(int j = i; j < n; j++)
            {
                    int ind = (int)(s.charAt(j) - 'a');
                    freq[ind]++;

                    sum += (getMaxCount(freq) - getMinCount(freq));
                
            }

        }

        return sum;
    }
}
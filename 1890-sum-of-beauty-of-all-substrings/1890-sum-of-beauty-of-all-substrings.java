class Solution {
    public int beautySum(String s) {
        
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int[] freq = new int[26];
                int minFreq = n + 1;
                int maxFreq = 0; 

                for(int k = i; k <= j; k++)
                {
                    int ind = (int)(s.charAt(k) - 'a');
                    freq[ind]++;
                }

                for(int t = 0; t < 26 ; t++)
                {
                    if(freq[t] > 0)
                    {
                        if(minFreq > freq[t])
                        {
                            minFreq = freq[t];
                        }

                        if(maxFreq < freq[t])
                        {
                            maxFreq = freq[t];
                        }
                    }
                }

                sum += (maxFreq - minFreq);
                
            }

        }

        return sum;
    }
}
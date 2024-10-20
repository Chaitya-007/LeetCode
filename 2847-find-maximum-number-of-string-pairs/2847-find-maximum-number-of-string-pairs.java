class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        // HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = words.length;
        boolean[] arr = new boolean[words.length];
        Arrays.fill(arr,false);
        int res = 0;

        for(int i = 0; i < n; i++)
        {
            if(arr[i])
            {
                continue;
            }
            for(int j = 0; j < n; j++)
            {
                if(i!=j)
                {
                    StringBuilder sb = new StringBuilder(words[j]);
                    if(words[i].equals(sb.reverse().toString()))
                    {
                        res++;
                        arr[i] = true;
                        arr[j] = true;
                    }
                }
            }
        }

        return res;
    }
}
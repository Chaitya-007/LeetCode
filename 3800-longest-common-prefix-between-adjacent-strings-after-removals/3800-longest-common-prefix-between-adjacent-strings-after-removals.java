class Solution {

    public int lcp(String p, String q)
    {
        int cnt = 0;
        int minlen = Math.min(p.length(),q.length());

        for(int i = 0; i < minlen; i++)
        {
            if(p.charAt(i) == q.charAt(i))
            {
                cnt++;
            }
            else
            {
                break;
            }
        }

        return cnt;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[n];

        if(n == 1 || n == 2) return ans;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for(int i = 1; i < n; i++)
        {
            prefix[i] = Math.max(prefix[i-1],lcp(words[i-1],words[i]));
        }

        for(int i = n - 2; i >= 0; i--)
        {
            suffix[i] = Math.max(suffix[i+1], lcp(words[i],words[i+1]));
        }


        for(int i = 0; i < n; i++)
        {
            if(i - 1 >= 0)
            {
                ans[i] = Math.max(prefix[i- 1],ans[i]);
            }

            if(i + 1 <= n - 1)
            {
                ans[i] = Math.max(suffix[i+1],ans[i]);
            }

            if(i - 1 >= 0 && i + 1 <= n -1)
            {
                ans[i] = Math.max(lcp(words[i-1],words[i+1]), ans[i]);
            }
        }

        return ans;
    }
}
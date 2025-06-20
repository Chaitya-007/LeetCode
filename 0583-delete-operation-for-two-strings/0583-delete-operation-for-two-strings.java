class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int j = 0; j <= m; j++) prev[j] = 0;

        for(int i = 1; i <= n; i++)
        {
            curr[0] = 0;
            for(int j = 1; j <= m; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    curr[j] = 1 + prev[j-1];
                }
                else
                {
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }

            prev = curr.clone();
        }

        int deletions = n - prev[m];

        int insertions = m - prev[m];

        return (deletions + insertions);
    }
}
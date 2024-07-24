class Solution {
    public String reversestring(String str)
    {
        StringBuilder st = new StringBuilder(str);
        st.reverse();
        return st.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        int cnt_pair = 0;
        int[] visited = new int[words.length];
        Arrays.fill(visited,0);

        for(int i = 0; i < words.length; i++)
        {
            if(visited[i] == 0)
            {
            String revstr = reversestring(words[i]);
            
            for(int j = i + 1; j < words.length; j++)
            {
                if(visited[j] == 0 && revstr.equals(words[j]))
                {
                    cnt_pair++;
                    visited[i] = 1;
                    visited[j] = 1;
                    break;
                }
            }

            }


        }

        return cnt_pair;

    }
}
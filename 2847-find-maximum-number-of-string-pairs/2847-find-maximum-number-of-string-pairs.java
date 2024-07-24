class Solution {
    public String reversestring(String str)
    {
        StringBuilder st = new StringBuilder(str);
        st.reverse();
        return st.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        // int cnt_pair = 0;
        // int[] visited = new int[words.length];
        // Arrays.fill(visited,0);

        // for(int i = 0; i < words.length; i++)
        // {
        //     if(visited[i] == 0)
        //     {
        //     String revstr = reversestring(words[i]);
            
        //     for(int j = i + 1; j < words.length; j++)
        //     {
        //         if(visited[j] == 0 && revstr.equals(words[j]))
        //         {
        //             cnt_pair++;
        //             visited[i] = 1;
        //             visited[j] = 1;
        //             break;
        //         }
        //     }

        //     }


        // }

        // return cnt_pair;

        // M 2
        int cnt = 0;
        Map<String,Integer> mp = new HashMap<String,Integer>();

        for(String str : words)
        {
            String rev = reversestring(str);
            if(mp.containsKey(str)) // check the string of array => do not reverse it and check it
            {

                cnt++;
                mp.remove(rev);
            }
            else
            {
                mp.put(rev,1);
            }
        }

        return cnt;

    }
}
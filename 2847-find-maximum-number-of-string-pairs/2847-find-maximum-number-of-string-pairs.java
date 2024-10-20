class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        // boolean[] arr = new boolean[words.length];
        // Arrays.fill(arr,false);
        // int res = 0;

        // for(int i = 0; i < n; i++)
        // {
        //     if(arr[i])
        //     {
        //         continue;
        //     }
        //     for(int j = 0; j < n; j++)
        //     {
        //         if(i!=j)
        //         {
        //             StringBuilder sb = new StringBuilder(words[j]);
        //             if(words[i].equals(sb.reverse().toString()))
        //             {
        //                 res++;
        //                 arr[i] = true;
        //                 arr[j] = true;
        //             }
        //         }
        //     }
        // }

        // return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int res = 0;


        for(int i = 0; i < n; i++ )
        {
            StringBuilder sb = new StringBuilder(words[i]);

            if(map.containsKey(words[i]))
            {
                res++;
            }
            else
            {
                map.put(sb.reverse().toString(),1);
            }
        }

        return res;
    }
}
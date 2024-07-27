class Solution {
    public int similarPairs(String[] words) {
        int[] visited = new int[words.length];
        Arrays.fill(visited,0);
        int cnt = 0;
        
        for(int i = 0; i < words.length; i++)
        {

            // if(visited[i] == 1)
            // {
            //     continue;
            // }

            HashSet<Character> set1 = new HashSet<Character>();

            for(int k = 0; k < words[i].length(); k++)
            {
                set1.add(words[i].charAt(k));
            }

            for(int j = i + 1; j < words.length; j++)
            {
                // if(visited[j] == 1)
                // {
                //     continue;
                // }
                HashSet<Character> set2 = new HashSet<Character>();

                for(int m = 0; m < words[j].length(); m++)
                {
                   set2.add(words[j].charAt(m));
                }

                if(set1.equals(set2))
                {
                    System.out.println("set1 " + set1 + " set2 " + set2);
                    // visited[i] = 1;
                    // visited[j] = 1;
                    cnt++;
                }

            }
        }

        for(int num : visited)
        {
            System.out.print(num + " ");
        }

        // for(int i = 0; i < visited.length; i++)
        // {
        //     if(visited[i] == 1)
        //     {
        //         cnt++;
        //     }
        // }

        return cnt;
    }
}
class Solution {
    public int similarPairs(String[] words) {
        int[] visited = new int[words.length];
        Arrays.fill(visited,0);
        int cnt = 0;

        for(int i = 0; i < words.length; i++)
        {
            Set<Character> hset1 = new HashSet<Character>();
           
                String str = words[i];
                for(int k = 0; k < str.length(); k++)
                {
                    hset1.add(str.charAt(k));
                }


                for(int j = 0; j < words.length; j++)
                {
                    if(i != j)
                    {
                        String temp = words[j];
                        Set<Character> hset2 = new HashSet<Character>();
                        for(int k = 0; k < temp.length(); k++)
                        {
                            hset2.add(temp.charAt(k));
                        }

                        if(hset1.equals(hset2))
                        {
                            visited[i] = 1;
                            visited[j] = 1;
                            cnt++;
                        }
                    }
                }
            
        }

        return cnt/2;
    }
}
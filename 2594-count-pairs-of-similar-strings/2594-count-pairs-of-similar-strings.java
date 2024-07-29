class Solution {
    public int similarPairs(String[] words) {

        int cnt = 0;

        for(int i = 0; i < words.length; i++)
        {
        Set<Character> s1 = new HashSet<Character>();
            
            for(int k = 0; k < words[i].length(); k++)
            {
                s1.add(words[i].charAt(k));
            }

            for(int j = i + 1; j < words.length; j++)
            {
                Set<Character> s2 = new HashSet<Character>();

                for(int u = 0; u < words[j].length(); u++)
                {
                    s2.add(words[j].charAt(u));
                }

                if(s1.equals(s2))
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
class Solution {
    public int similarPairs(String[] words) {

        int cnt = 0;

        for(int i = 0; i < words.length; i++)
        {
        HashSet<Character> hset1 = new HashSet<Character>();
            for(char ch : words[i].toCharArray())
            {
                hset1.add(ch);
            }
            for(int j = i + 1; j < words.length; j++)
            {
        HashSet<Character> hset2 = new HashSet<Character>();
                for(char ch : words[j].toCharArray())
                {
                    hset2.add(ch);
                }
                if(hset1.equals(hset2))
                {
                    cnt++;
                }
            }

        }

            return cnt;

    }
}
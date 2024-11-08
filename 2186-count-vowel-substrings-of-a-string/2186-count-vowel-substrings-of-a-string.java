class Solution {
    public int countVowelSubstrings(String word) {
        String vowel = "aeiou";
        int n = word.length();
        int cnt = 0;

        for(int i = 0; i < n; i++)
        {
            Set<Character> hset = new HashSet<Character>();
            for(int j = i; j < n; j++)
            {
                if(vowel.indexOf(word.charAt(j)) >= 0)
                {
                    hset.add(word.charAt(j));
                    int len = hset.size();
                    if(len == 5)
                    {
                        cnt++;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        return cnt;
    }
}
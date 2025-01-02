class Solution {
    public int countVowelSubstrings(String word) {
        int cnt = 0;
        String vowels = "aeiou";
        int n = word.length();

        for(int i = 0; i <= (n - 5); i++)
        {
            HashSet<Character> hset = new HashSet<Character>();
            for(int j = i; j < n; j++)
            {
                char ch = word.charAt(j);
                if(vowels.indexOf(ch) >= 0)
                {
                    hset.add(ch);
                    if(hset.size() == 5)
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
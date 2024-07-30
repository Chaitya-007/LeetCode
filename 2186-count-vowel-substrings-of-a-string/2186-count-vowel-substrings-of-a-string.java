class Solution {
    public int countVowelSubstrings(String word) {
        String vowel = "aeiou";
        int cnt = 0;


        for(int i = 0; i <= (word.length() - 5); i++)
        {
        HashSet<Character> set = new HashSet<Character>();
            for(int j = i ; j < word.length(); j++)
            {
                char ch = word.charAt(j);

                if(vowel.contains(String.valueOf(ch)))
                {
                    System.out.println("Element = " + word.charAt(j));
                    set.add(ch);
                    int len = set.size();
                    if(len == 5)
                    {
                        cnt++;
                        System.out.println("cnt = " + cnt);
                    }
                }
                else if(set.size() > 0)
                {
                    System.out.println("breaked");
                    break;
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
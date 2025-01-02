class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        String vowel = "aeiou";
        int cnt = 0;

        for(int i = left; i <= right; i++)
        {
            int n = words[i].length();
            char first = words[i].charAt(0);
            char last = words[i].charAt(n-1);
            if(vowel.indexOf(first) >= 0 && vowel.indexOf(last) >= 0 )
            {
                cnt++;
            }
        }

        return cnt;
    }
}
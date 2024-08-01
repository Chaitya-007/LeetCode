class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] first = new int[26];
        int[] second = new int[26];
        Arrays.fill(first,0);
        Arrays.fill(second,0);

        for(int i = 0; i < word1.length(); i++)
        {
            first[word1.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < word2.length(); i++)
        {
            second[word2.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < 26; i++)
        {
            int diff = Math.abs(first[i] - second[i]);
            if(diff > 3)
            {
                return false;
            }
        }

        return true;
        
    }
}
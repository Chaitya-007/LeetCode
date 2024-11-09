class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);

        for(int i = 0; i < word1.length(); i++)
        {
            int ind = (int)(word1.charAt(i) - 'a');
            arr1[ind] = arr1[ind] + 1;
        }

        for(int j = 0; j < word2.length(); j++)
        {
            int ind = (int) (word2.charAt(j) - 'a');
            arr2[ind] = arr2[ind] + 1;
        }

        for(int i = 0; i < 26; i++)
        {
            if(Math.abs(arr1[i] - arr2[i]) > 3)
            {
                return false;
            }
        }
        return true;
    }
}
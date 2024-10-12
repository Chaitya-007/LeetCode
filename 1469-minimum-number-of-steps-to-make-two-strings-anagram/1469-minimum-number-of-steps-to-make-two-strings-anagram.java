class Solution {
    public int minSteps(String s, String t) {
        int[] arrs = new int[26];
        int[] arrt = new int[26];
        

        for(char itr : s.toCharArray())
        {
            arrs[(int)(itr - 'a')] += 1;
        }

        for(char itr : t.toCharArray())
        {
            arrt[(int)(itr - 'a')] += 1;
        }

        int res = 0;

        for(int i = 0; i < 26; i++)
        {
            res += Math.abs(arrs[i] - arrt[i]);
        }

        return res/2;

    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder("");
        int minInd = -1;
        int n = strs.length;


        for(int i = 0; i < Math.min(strs[0].length(), strs[n-1].length()); i++)
        {
            if(strs[0].charAt(i) == strs[n-1].charAt(i))
            {
                minInd = i;
            }
            else
            {
                break;
            }
        }

        if(minInd == -1) return "";

        return strs[0].substring(0,minInd + 1);
    }
}
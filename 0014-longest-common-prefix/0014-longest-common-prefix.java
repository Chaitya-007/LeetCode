class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
        {
            return strs[0];
        }

        Arrays.sort(strs); // Very Very Important
        int n = strs.length;
        int len = Math.min(strs[0].length(),strs[n-1].length());
        String temp = "";
        String first = strs[0];
        String last = strs[n-1];

        for(int i = 0; i < len; i++)
        {
            if(first.charAt(i) == last.charAt(i))
            {
                temp += strs[0].charAt(i);
            }
            else
            {
                break;
            }
        }
        return temp;
    }
}
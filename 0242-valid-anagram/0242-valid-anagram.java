class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        Arrays.sort(chs);
        Arrays.sort(cht);

        for(int i = 0; i < chs.length; i++)
        {
            if(chs[i] != cht[i])
            {
                return false;
            }
        }

        return true;
    }
}
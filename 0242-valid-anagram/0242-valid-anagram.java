class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        char[] sh = s.toCharArray();
        char[] th = t.toCharArray();

        Arrays.sort(sh);
        Arrays.sort(th);

        for(int i = 0; i < s.length(); i++)
        {
            if(sh[i] != th[i]) return false;
        }

        return true;
    }
}
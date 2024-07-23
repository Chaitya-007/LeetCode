class Solution {
    public String restoreString(String s, int[] indices) {
        char[] charray = new char[s.length()];

        for(int i = 0; i < indices.length; i++)
        {
            charray[indices[i]] = s.charAt(i);
        }

        String str = "";

        for(char i : charray)
        {
            str += i;
        }

        return str;
    }
}
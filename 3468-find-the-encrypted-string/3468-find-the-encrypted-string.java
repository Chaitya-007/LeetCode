class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < n; i++)
        {
            int ind = (i+k)%n;
            char ch = s.charAt(ind);
            sb.append(ch);
        }

        return sb.toString();
    }
}
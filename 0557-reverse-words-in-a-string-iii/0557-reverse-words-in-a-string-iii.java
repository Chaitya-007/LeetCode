class Solution {

    public void reverse(char[] ch, int l, int r)
    {
        while(l < r)
        {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }

    public String reverseWords(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int start = 0;

        for(int i = 0; i < n; i++)
        {
            if(ch[i] == ' ')
            {
                reverse(ch,start,i-1);
                start = i + 1;
            }
        }

        reverse(ch,start,n-1);
        StringBuilder sb = new StringBuilder("");
        return sb.append(ch).toString();
    }
}
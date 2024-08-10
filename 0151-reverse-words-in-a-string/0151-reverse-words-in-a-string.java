class Solution {

    void reverseString(char[] str,int start, int end)
    {

    }

    public String reverseWords(String s) 
    {
        char[] charArray = s.toCharArray();
        int start = 0;
        ArrayList<String> list = new ArrayList<String>();
        String str = "";
        

        for(int i = 0; i < s.length(); i++)
        {
            if(charArray[i] == ' ')
            {
                if(str.length() != 0)
                {
                    list.add(str);
                    str = "";
                }
            }
            else
            {
                str += s.charAt(i);
            }
        }

        if(str.length() != 0)
        {
            list.add(str);
            str = "";
        }
        str = "";

        int n = list.size();

        for(int i = 0; i < n; i++)
        {
            StringBuilder sb = new StringBuilder(list.get(i));
            String temp = sb.reverse().toString();
            if(i == n - 1)
            {
                str += temp;
            }
            else
            {

            str += temp + " ";
            }

        }

        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString();

    }
}
class Solution {

    public static void reverse(char[] str, int left, int right)
    {
        while(left < right)
        {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        // String[] arr = s.split(" ");
        // String result = "";

        // for(String str : arr)
        // {
        //     StringBuilder sb = new StringBuilder(str);
        //     sb.reverse();
        //     result += sb.toString() + " ";
        // }

        // return result.trim(); // removes extra spaces before and leading 

        // M2
        char []strchar = s.toCharArray();
        int start = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(strchar[i] == ' ')
            {
                reverse(strchar,start,i - 1);
                start = i + 1;
            }
            else if(i == s.length() - 1)
            {
                reverse(strchar,start,i);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        sb.append(strchar);
        return sb.toString();
    }
}
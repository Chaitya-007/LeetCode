class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String result = "";

        for(String str : arr)
        {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            result += sb.toString() + " ";
        }

        return result.trim(); // removes extra spaces before and leading 
    }
}
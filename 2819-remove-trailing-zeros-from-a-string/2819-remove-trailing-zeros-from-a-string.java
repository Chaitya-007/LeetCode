class Solution {
    public String removeTrailingZeros(String num) {
        String res = "";
        for(int i = num.length() - 1; i >= 0; i--)
        {
            if(num.charAt(i) != '0')
            {
                res += num.substring(0,i+1);
                break;
            }
        }

        return res;
    }
}
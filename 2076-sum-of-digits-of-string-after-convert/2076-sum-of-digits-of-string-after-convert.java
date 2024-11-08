class Solution {

    public static String convert(String str)
    {
        int n = str.length();
        String result = "";
        for(int i = 0; i < n; i++)
        {

        String temp = "";   
            int num = (int)((str.charAt(i) - 'a') + 1);
            while(num > 0)
            {
                int rem = num%10;
                num = num/10;
                char ch = (char)(rem + '0');
                temp = ch + temp;
            }
            result += temp;

        }

        return result;
    }

    public int getLucky(String s, int k) {
        
        String newStr = convert(s);

        int sum = 0;
        // Transform 1
        for(int i = 0; i < newStr.length(); i++)
        {
            int num = (int) (newStr.charAt(i) - '0');
            sum += num;
        }

        // one transform done
        k--;

        int temp = sum;
        while(k > 0)
        {
            sum = 0;
            while(temp > 0)
            {
                int rem = temp%10;
                sum += rem;
                temp = temp/10;
            }
            temp = sum;
            k--;
        }

        return temp;
    }
}
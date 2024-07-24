class Solution {
    public String generateTheString(int n) {
        
        String str = "";
        
        if(n%2 == 1)
        {
            while(n > 0)
            {
                str += "a";
                n--;
            }
        }
        else
        {
            n = n - 1;
           while(n > 0)
           {
            str += "a";
            n--;
           }
           str += "b";
        }
        return str;
    }
}
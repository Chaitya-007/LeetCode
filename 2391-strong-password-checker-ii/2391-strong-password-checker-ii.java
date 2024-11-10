class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();

        if(n < 8)
        {
            return false;
        }

        String special = "!@#$%^&*()-+";
        int dig = 0;
        int high = 0;
        int low = 0;
        int spchar = 0;

        for(int i = 0; i < n; i++)
        {
            char ch = password.charAt(i);
            if(i != 0)
            {
                if(password.charAt(i) == password.charAt(i-1))
                {
                    return false;
                }
            }

            if('0' <= ch && ch <= '9')
            {
                dig = 1;
            }

            if('A' <= ch && ch <= 'Z')
            {
                high = 1;
            }

            if('a' <= ch && ch <= 'z')
            {
                low = 1;
            }

            if(special.indexOf(ch) >= 0)
            {
                spchar = 1;
            }
        }

        if(dig == 1 && low == 1 && high == 1 && spchar == 1)
        {
            return true;
        }

        return false;


    }
}
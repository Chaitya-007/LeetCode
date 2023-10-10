class Solution {
public:
    bool isPalindrome(int x) {
        // long long res = 0;
        // int rem;
        // int temp = x;
        
        // if(x<0)
        // {
        //     return false;
        // }
        
        // while(x>0)
        // {
        //     rem = x%10;
        //     x = x/10;
        //     res = rem + (res*10);
        // }
        // if(temp == res)
        // {
        //     return true;
        // }
        // return false;

        if(x<0)
        {
            return false;
        }

        string str = to_string(x);
        string temp = str;
        reverse(temp.begin(),temp.end());
        if(temp == str)
        {
            return true;
        }
        return false;
    }
};
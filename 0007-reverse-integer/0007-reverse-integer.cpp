class Solution {
public:
    int reverse(int x) {

        long long rev = 0;
        int rem = 0;
       

        while(x) // this works for both positive and negative
        {
            rem = x%10;
            x = x/10;
            rev = rem + rev*10;
        }

        if(rev < INT_MIN || rev > INT_MAX)
        {
            return 0;
        }

        return rev;
    }
};
class Solution {
public:
    int reverse(int x) {

        bool negative = false;
        long long temp = abs(x);
        long long rev = 0;
        int rem = 0;
        if(x<0)
        {
            negative = true;
        }

        while(temp) // this works for both positive and
        {
            rem = temp%10;
            temp = temp/10;
            rev = rem + rev*10;
        }

        if(negative)
        {
            rev = (-1)*rev;
        }

        if(rev < INT_MIN || rev > INT_MAX)
        {
            return 0;
        }

        return rev;
    }
};
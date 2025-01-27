// TahmidRanon
// Jun 07, 2024
// assume the number n is a negative integer, n=-16. the question asks if it can be shown as a power of 2 right? lets do that. we get,
// -16/2=-8,
// -8/2=-4,
// -4/2=-2,
// -2/2=-1
// you know that
// 2^1=2
// 2^0=1
// 2^-1=1/2
// 2^-2=1/4
// which means no matter what you put as the power of 2 you will never get a negative answer, meaning no negative integer can be written as a power of 2
// I hope that helps


class Solution {
    public boolean isPowerOfTwo(int n) {

        // power of two can never be negative

        // if(n < 0) return false;
        // if(n == 0) return false;

        // return (n & (n-1)) == 0 ? true : false;

        return n > 0 && Integer.bitCount(n) == 1;
    }
}
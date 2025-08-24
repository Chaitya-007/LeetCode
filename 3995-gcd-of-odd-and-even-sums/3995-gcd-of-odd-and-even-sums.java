class Solution {

    public int getGCD(int m, int n)
    {
        while(m != 0 && n != 0)
            {
                if(m > n) m = m%n;
                else n = n%m;
            }

        if(m == 0) return n;
        return m;
    }


    
    public int gcdOfOddEvenSums(int n) {
        int sumOfOdd = (n*n);
        int sumOfEven = (n)*(n + 1);

        int res = getGCD(sumOfOdd, sumOfEven);
        return res;
    }
}
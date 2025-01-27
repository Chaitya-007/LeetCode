class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow cases first
        if (dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
            
        // Handle edge cases
        if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
            
        // Convert to long to handle MIN_VALUE case
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        // Determine sign of result
        boolean sign = (dividend > 0) == (divisor > 0);
        
        long quotient = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            dvd -= temp;
            quotient += multiple;
        }
        
        return sign ? (int)quotient : (int)(-quotient);
    }
}
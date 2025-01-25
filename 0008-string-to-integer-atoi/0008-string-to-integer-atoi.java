class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int num = 0;

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        char sign = '+';

        // Determine the sign
        if (s.charAt(i) == '-') {
            sign = '-';
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Skip leading zeros
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > Integer.MAX_VALUE / 10 || 
                (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign == '-' ? -num : num;
    }
}
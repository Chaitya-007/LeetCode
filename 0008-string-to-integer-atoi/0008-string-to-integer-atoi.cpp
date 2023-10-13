class Solution {
public:
    int myAtoi(string s) {
        // int n = s.length();
        
        // int positive = 0;
        // int negative = 0;
        // int i = 0;

        // while(s[i] == ' ')
        // {
        //     i++;
        // }

        // while(s[i] == '+')
        // {
        //     positive++;
        // }

        // while(s[i] == '-')
        // {
        //     negative++;
        // }

        // while(i < n)

        int i = 0;
  while (i < s.length() && isspace(s[i])) {
    i++;
  }

  // Check for sign.
  int sign = 1;
  if (i < s.length() && (s[i] == '+' || s[i] == '-')) {
    sign = (s[i] == '-') ? -1 : 1;
    i++;
  }

  // Read digits.
  int result = 0;
  while (i < s.length() && isdigit(s[i])) {
    int digit = s[i] - '0';
    if (result > (INT_MAX - digit) / 10) {
      return sign == 1 ? INT_MAX : INT_MIN;
    }
    result = result * 10 + digit;
    i++;
  }

  // Apply sign and return result.
  return sign * result;


    }
};
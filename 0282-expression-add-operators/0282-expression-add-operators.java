class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder expression, String num, 
                          int target, int index, long evaluated, long lastNum) {
        // Base case: reached the end of the string
        if (index == num.length()) {
            if (evaluated == target) {
                result.add(expression.toString());
            }
            return;
        }
        
        // Save current expression length for backtracking
        int len = expression.length();
        
        for (int i = index; i < num.length(); i++) {
            // Handle leading zeros - skip if current position is not the first digit
            // and the digit at index is '0'
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            
            // Extract current number
            String currStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);
            
            // If this is the first number, we don't need any operator
            if (index == 0) {
                expression.append(currStr);
                backtrack(result, expression, num, target, i + 1, currNum, currNum);
                expression.setLength(len);
            } else {
                // Addition
                expression.append("+").append(currStr);
                backtrack(result, expression, num, target, i + 1, evaluated + currNum, currNum);
                expression.setLength(len);
                
                // Subtraction
                expression.append("-").append(currStr);
                backtrack(result, expression, num, target, i + 1, evaluated - currNum, -currNum);
                expression.setLength(len);
                
                // Multiplication - needs special handling for precedence
                // We need to undo the last operation and apply multiplication first
                expression.append("*").append(currStr);
                backtrack(result, expression, num, target, i + 1, 
                        evaluated - lastNum + (lastNum * currNum), lastNum * currNum);
                expression.setLength(len);
            }
        }
    }
}
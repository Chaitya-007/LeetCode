class Solution {
    public int maxDepth(String s) {
        int cnt = 0;
        int maxCount = 0;
        Stack<Character> st = new Stack<Character>();

        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                cnt++;
            }
            else if(ch == ')')
            {
                cnt--;
            }

            maxCount = Math.max(maxCount,cnt);
        }

        return maxCount;
    }
}
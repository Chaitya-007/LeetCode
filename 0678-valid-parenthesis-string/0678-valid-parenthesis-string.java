class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int lower = 0;
        int higher = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                lower = lower + 1;
                higher = higher + 1;
            }
            else if(ch == ')')
            {
                lower = lower - 1;
                higher = higher - 1;
            }
            else 
            {
                lower = lower - 1;
                higher = higher + 1;
            }

            if(lower < 0) lower = 0;
            if(higher < 0)
            {
                // right side we don't have any value
                // not possible
            return false;
            } 
        }

        return lower == 0;
    }
}
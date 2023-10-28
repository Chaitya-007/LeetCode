class Solution {
public:
    int balancedStringSplit(string s) {
        int stringcount = 0;
        int rcount = 0;
        int lcount = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == 'R')
            {
                rcount++;
            }
            if(s[i] == 'L')
            {
                lcount++;
            }
            if(rcount == lcount)
            {
                rcount = 0;
                lcount = 0;
                stringcount++;
            }
        }

        return stringcount;
        
    }
};
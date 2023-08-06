// https://leetcode.com/contest/weekly-contest-357/problems/faulty-keyboard/

class Solution {
public:
    string finalString(string s) {
        string res;
        int len = s.length();
        
        for(int i = 0; s[i] != '\0'; i++)
        {
            
            if(s[i] != 'i')
            {
                res += s[i];
                
            }
            
            else
            {
                int resLength = res.length();
                for(int j = 0 ; j < resLength/2 ; j++)
                {
                    char temp = res[j];
                    res[j] = res[(resLength-1) - j];
                    res[(resLength-1) - j] = temp;
                }
            }
            
        
        }
        
        return res;
    }
};

class Solution {
public:
    string reverseWords(string s) 
    {
        // string res;
        // string part;
        // int n = s.length();
        // for(int i = 0; i < n; i++)
        // {


        //     if(s[i] == ' ')
        //     {
        //         reverse(part.begin(),part.end());
        //         res += part + ' ';
        //         part = "";
        //     }
        //     else
        //     {
        //         part += s[i];
        //     }

        //     if(i == (n - 1))
        //     {
        //         reverse(part.begin(),part.end());
        //         res += part;
        //     }
        // }

        // return res;

        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == ' '|| i == (s.length() - 1))
            {
                if(i == (s.length() - 1))
                {
                    r = i;
                }
                else
                {
                    r = i - 1;
                }
                
                while(l < r)
                {
                    char temp = s[l];
                    s[l] = s[r];
                    s[r] = temp;
                    l++;
                    r--;
                }
                if(i != (s.length() - 1))
                {
                    l = i + 1;
                }
                
            }
        }

        return s;
        
    }
};
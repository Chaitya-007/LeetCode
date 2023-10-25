class Solution {
public:
    bool check(string test)
    {
        int l = 0;
        int r = test.length() - 1;
        while(l < r)
        {
            if(test[l] != test[r])
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    string longestPalindrome(string s) 
    {
        
            int len = 0;
            string res = s.substr(0,1);

            for(int left = 0; left < s.length(); left++)
            {

                int right = s.length() - 1;
                while(left < right)
                {
                    if(s[left] != s[right])
                    {
                        right--;
                    }
                    else
                    {
                        string str = s.substr(left,(right - left) + 1);
                        if(str.length() > len and check(str))
                        {
                            len = str.length();
                            res = str;
                        }
                        right--;
                    }

                }
            }
        return res;
        
    }
};
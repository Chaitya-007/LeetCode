class Solution {
public:
    bool halvesAreAlike(string s)
    {
        // string firsthalf;
        // string secondhalf;

         int countfirst = 0;
         int countsecond = 0;

         set<char> st;
         st = {'a','e','i','o','u','A','E','I','O','U'};
         int n = s.length();

        for(int i = 0; i < n; i++)
        {
            if(i < n/2)
            {
                // firsthalf += s[i];
                if(st.find(s[i]) != st.end())
                {
                    countfirst++;
                }
            }
            else
            {
                // secondhalf += s[i];
                if(st.find(s[i]) != st.end())
                {
                    countsecond++;
                }
            }
        }

            if(countfirst == countsecond)
            {
                return true;
            }

            return false;
    }
};
class Solution {
public:
    bool isValid(string s) {
        stack<char>st;

        // t.c = O(n)
        // s.c = O(n)

        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == '(')
            {
                st.push(s[i]);
            }
            if(s[i] == '[')
            {
                st.push(s[i]);
            }
            if(s[i] == '{')
            {
                st.push(s[i]);
            }

            if(s[i] == ')')
            {
                if(!st.empty() and st.top() == '(')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }

            if(s[i] == ']')
            {
                if(!st.empty() and st.top() == '[')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
            
            if(s[i] == '}')
            {
                if(!st.empty() and st.top() == '{')
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        
        if(st.empty())
        {
            return true;
        }

        return false;
        
    }
};
class Solution {
public:
    vector<int> diStringMatch(string s)
    {
        vector<int> vec;
        stack<int> st;
        int num = 0;

        for(int i = 0; i < s.length(); i++)
        {
            st.push(num++);
            if(s[i] == 'I')
            {
                while(!st.empty())
                {
                    vec.emplace_back(st.top());
                    st.pop();
                }
            }
        }

        st.push(num);

        while(!st.empty())
        {
            vec.emplace_back(st.top());
            st.pop();
        }

        return vec;

    }
};
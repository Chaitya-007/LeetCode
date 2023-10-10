class Solution {
public:
    int strStr(string haystack, string needle) {

        if(haystack.length() < needle.length())
        {
            return -1;
        }
        for(int i = 0; i < ( (haystack.length() - needle.length()) + 1) ; i++)
        {
            if(haystack[i] == needle[0])
            {
                int k = i + 1;
                int flag = 1;
                for(int j = 1 ; j < needle.length() ; j++,k++)
                {
                    if(haystack[k] == needle[j])
                    {

                    }
                    else
                    {
                        flag = 2;
                        break;
                    }
                }
                if(flag == 1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
};
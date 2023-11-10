class Solution {
public:
    string freqAlphabets(string s)
    {
     map<int, char> mp;

    //  string str[26];

    //  for(int i = 1; i <= 26; i++)
    //  {
    //      string res = to_string(i);
    //      str[i-1] = res;
    //  }

     for(char c = 'a',i = 1; c <= 'z'; c++,i++)
     {
         mp[i] = c;
     } 

    //  for(auto itr = mp.begin(); itr != mp.end(); itr++)
    //  {
    //      cout<<itr->first<<"->"<<itr->second<<"\n";
    //  }

    int i = 0;
    string res;
    while(i < s.length())
    {
        if(i + 2 < s.length() and s[i + 2] == '#')
        {
            string st = s.substr(i,2);
            int value = stoi(st);
            char c = mp[value];
            res += c;
            i = i + 3;
        }
        else
        {
            string str = s.substr(i,1);
            int value = stoi(str);
            char c = mp[value];
            res += c;
            i++;
        }
    }

        return res;
    }
};
class Solution {
public:
    int numOfStrings(vector<string>& patterns, string word)
    {

        int flag = 1;
        int ans = 0;

     for(int i = 0; i < patterns.size(); i++)
     {
         string str = patterns[i];

         if(str.length() <= word.length())
         {
             int k = 0;
             while(k < (word.length() - str.length() + 1) )
             {
                 if(str[0] == word[k])
                 {
                     flag = 2;
                     int first = 1;
                     int second = k;
                     second++;

                    while(first < str.length())
                    {
                        if(str[first] == word[second])
                        {
                            flag = 2;
                            first++;
                            second++;
                        }
                        else
                        {
                            flag = 1;
                            break;
                        }
                    } 
                    if(flag == 2)
                    {
                        ans++;
                        break;
                    }

                 }

                 k++;
             }

         }
         
     }

     return ans;
    }
};
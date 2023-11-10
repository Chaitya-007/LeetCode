class Solution {
public:
    int maximumNumberOfStringPairs(vector<string>& words)
    {

        int count = 0;
     for(int i = 0; i < words.size(); i++)
     {
         for(int j = i + 1; j < words.size(); j++)
         {
             string revstring = words[j];
            reverse(revstring.begin(),revstring.end());
             if(words[i] == revstring)
             {
                 count++;
             }
         }
     }


     return count;   
    }
};
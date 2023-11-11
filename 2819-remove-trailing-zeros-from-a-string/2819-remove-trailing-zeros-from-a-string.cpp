class Solution {
public:
    string removeTrailingZeros(string num)
    {
        int i = 0;
     for(i = num.length() - 1; i >= 0; i--)
     {
         if(num[i] != '0')
         {
             break;
         }
     } 

     return num.substr(0,i+1);  
    }
};
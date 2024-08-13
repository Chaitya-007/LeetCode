class Solution {
public:

    // This is O(N*3)
    // bool check(string test)
    // {
    //     int l = 0;
    //     int r = test.length() - 1;
    //     while(l < r)
    //     {
    //         if(test[l] != test[r])
    //         {
    //             return false;
    //         }
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }


    string longestPalindrome(string s) 
    {
        
    //         int len = 0;
    //         string res = s.substr(0,1);

    //         for(int left = 0; left < s.length(); left++)
    //         {

    //             int right = s.length() - 1;
    //             while(left < right)
    //             {
    //                 if(s[left] != s[right])
    //                 {
    //                     right--;
    //                 }
    //                 else
    //                 {
    //                     string str = s.substr(left,(right - left) + 1);
    //                     if(str.length() > len and check(str))
    //                     {
    //                         len = str.length();
    //                         res = str;
    //                     }
    //                     right--;
    //                 }

    //             }
    //         }
    //     return res;
        
    // }

    // *****************************************
    // t.c = O(N*N)
    // s.c = O(1)
    // very fast

    // string longestPalindrome(string s) 
    // {
    //     if(s.length() <= 1)
    //     {
    //         return s;
    //     }

        
    //         int maxlen = 1;
    //         int n = s.length();
    //         int st = 0;

    //      for(int i = 0; i < n; i++)
    //         {
    //             int left = i;
    //             int right = i;

    //             while(left >=0 and right < n)
    //             {
    //                 if(s[left] == s[right])
    //                 {
    //                     left--;
    //                     right++;
    //                 }
    //                 else
    //                 {
    //                     break;
    //                 }
    //             }

    //             int len = right - left - 1;
    //             if(len > maxlen)
    //             {
    //                 maxlen = len;
    //                 st = left + 1;
    //             }
    //         }

    //     for(int i = 0; i < n - 1; i++)
    //     {
    //         int left = i;
    //         int right = i + 1;
    //         while(left >=0 and right < n)
    //         {
    //             if(s[left] == s[right])
    //             {
    //                 left--;
    //                 right++;
    //             }

    //             else
    //             {
    //                 break;
    //             }
    //         }

    //         int len = right - left - 1;
    //         if(len > maxlen)
    //         {
    //             maxlen = len;
    //             st = left + 1;
    //         }
    //     }

    //         return s.substr(st,maxlen);
        
           
        
    // }
// 
// // // dp[i][j] represents whether the string starting at i and ending at j is a palindrome.
// // // dp[j + 1][i - 1] represents whether the middle part excluding the starting and ending points is a palindrome.
// // // For example: b aca b
// // // dp[i][j] represents bcacb.
// // // dp[j + 1][i - 1] represents aca in this case.
// // // If the 'aca' part is true and the starting and ending points are equal, then the new string is also a palindrome.
// // // b aca b = aca + b=b
// Easy dp approach
    int n = s.length();
    string str = "";
    int ans = 0;
    vector<vector<int>> dp(n,vector<int>(n,0));
    for(int diff = 0; diff < n; diff++)
    {
        for(int i = 0, j = i + diff; j < n; i++,j++)
        {
            if(diff == 0)
            {
                dp[i][j] = 1;
            }
            else if(diff == 1)
            {
                if(s[i] == s[j])
                {
                    dp[i][j] = 2;
                }
            }
            else
            {
                if(s[i] == s[j])
                {
                    if(dp[i+1][j-1] > 0)
                    {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }
            }

            if(dp[i][j] > 0)
            {
                if(ans < (j - i + 1))
                {
                    ans = max(ans,j-i+1);
                    str = s.substr(i,ans);
                }
            }
        }
    }

    return str;

    }


};
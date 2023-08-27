class Solution {
public:
    long long minimumPossibleSum(int n, int target) {
        
//         long long sum = 1;
//         vector<int>v;
//         v.emplace_back(1);
//         int num = 2;
//         for(int i = 1 ; i < n ; i++)
//         {
        
//             int k = 0;
//          while(k < i)
//          {
//              if(num + v[k] == target)
//              {
//                  num++;
//                  k = 0;
//              }
//              else
//              {
//                  k++;
//              }
//          }
//             v.emplace_back(num);
//             num++;
//             sum = sum + v[i];
//         }
        
        int x = target/2;
        long long sum = 0;
        for(int i = 1; i <= x; i++)
        {
            sum = sum + i;
            n--;
            
            if(n == 0)
            {
                break;
            }
        }
        
        int z = target;
        while(n--)
        {
            sum = sum + z;
            z++;
        }
        
       
        return sum;

    }
};
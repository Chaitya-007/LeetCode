class Solution {
public:
    int minimumSum(int n, int k) {
        vector<int>v;
        int sum = 1;
        int arr[n];
        int i,j,m,s;
        
        if(n == 1)
        {
            return 1;
        }
        
        arr[0] = 1;
       
        for( i = 1,m = 2; i < n ; i++,m++)
        {
            for( j = 0, s = 0 ; s < i; j++)
            {
                if(arr[s] + m == k)
                {
                    m++;
                    s = 0;
                }
                else
                {
                     s++;
                }
               
            }
            arr[i] = m;
            sum = sum + arr[i];
        }
        
       // for(int i = 0; i < n ; i++)
       // {
       //     cout<<arr[i]<< " ";
       // }

        return sum;
    }
};
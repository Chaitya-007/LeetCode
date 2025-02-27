class Solution {
    public int candy(int[] ratings) {

        // T.C -> O(2*N)
        // S.C -> O(N)

        int n = ratings.length;

        int[] left = new int[n];

        left[0] = 1;

        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] < ratings[i])
            {
                left[i] = left[i-1] + 1;
            }
            else
            {
                left[i] = 1;
            }
        }


        int curr = 1;
        int right = 1;

        int sum = Math.max(left[n-1],right);
        

        for(int i = n - 2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i + 1])
            {
               curr = right + 1;
            }
            else
            {
                curr = 1;
            }
               right = curr;

            sum += Math.max(left[i],curr);
        }

        return sum;


    }
}
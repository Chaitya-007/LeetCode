class Solution {
    public int candy(int[] ratings) {

        // T.C -> O(N)
        // S.C -> O(1)

        int n = ratings.length;

        int sum = 1;

        int i = 1; 

        while(i < n)
        {
            if(ratings[i-1] == ratings[i])
            {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;

            while(i < n && ratings[i-1] < ratings[i])
            {
                peak = peak + 1;
                sum += peak;
                i++;
            }

            int down = 0;

            while(i < n && ratings[i - 1] > ratings[i])
            {
                down = down + 1;
                sum += down;
                i++;
            }

            down++;

            if(down > peak)
            {
                sum += (down - peak);
            }
        }

        return sum;


    }
}
class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int[] cand = new int[n];
        Arrays.fill(cand,1);

        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] > ratings[i])
            {
                int ind = i;

                while(ind > 0 && ratings[ind-1] > ratings[ind] && cand[ind - 1] <= cand[ind])
                {
                    cand[ind - 1] = cand[ind] + 1;
                    ind--;
                }
            }
            else if(ratings[i-1] < ratings[i])
            {
                int ind = i;

                while(ind < n && ratings[ind - 1] < ratings[i] && cand[ind-1] >= cand[ind])
                {
                    cand[ind] = cand[ind - 1] + 1;
                    ind++;
                }
            }
        }

        int sum = 0;
        for(int val : cand) sum += val;

        return sum;
    }
}
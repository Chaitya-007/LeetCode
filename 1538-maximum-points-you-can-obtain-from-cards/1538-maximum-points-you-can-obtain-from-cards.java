class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int lsum = 0;
        int rsum = 0;

        int l = 0;
        int r = n - 1;
        int maxSum = 0;
        
        while(l < k)
        {
            lsum += cardPoints[l];
            maxSum = Math.max(maxSum,lsum);
            l++;
        }

        l--;

        while(l >= 0)
        {
            lsum -= cardPoints[l];
            rsum += cardPoints[r];
            maxSum = Math.max(maxSum, lsum + rsum);
            l--;
            r--;
        }

        return maxSum;
    }
}
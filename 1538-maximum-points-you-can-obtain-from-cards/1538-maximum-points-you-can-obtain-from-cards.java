class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;

        int maxSum = 0;

        int n = cardPoints.length;
        int l = 0;
        int r = n - 1;

        while(l < k)
        {
            lsum += cardPoints[l];
            l++;
        }

        maxSum = Math.max(maxSum,lsum);
        System.out.println(maxSum);

        l--;
        while(l >= 0)
        {
            lsum -= cardPoints[l];
            l--;
            rsum += cardPoints[r];
            r--;

            maxSum = Math.max(maxSum, lsum + rsum);
        System.out.println(maxSum);
        }

        return maxSum;
    }
}
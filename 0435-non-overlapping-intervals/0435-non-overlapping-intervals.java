class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {



        Arrays.sort(intervals, (interval1,interval2)->
        {
            return Integer.compare(interval1[1],interval2[1]);
        });

        int cnt = 1;
        int n = intervals.length;

        int lastEnd = intervals[0][1];
        int i = 1;

        while(i < n)
        {
            if(intervals[i][0] >= lastEnd)
            {
                cnt++;
                lastEnd = intervals[i][1];
            }
            i++;
        }

        return n - cnt;

    }
}
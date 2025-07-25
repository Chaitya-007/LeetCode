class Solution {
    public int[][] merge(int[][] intervals) {
        // T.C -> O(NlogN) + O(N)
        // S.C -> O(N)

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] res = new int[1][2];

        int n = intervals.length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

            res[0][0] = intervals[0][0];
            
            res[0][1] = intervals[0][1];
        int i = 0;

        while(i < n)
        {

            if(res[0][1] >= intervals[i][0])
            {
                res[0][0] = Math.min(res[0][0],intervals[i][0]);
                res[0][1] = Math.max(res[0][1],intervals[i][1]);
            }
            else
            {
            list.add(new Pair<>(res[0][0],res[0][1]));
            res[0][0] = intervals[i][0];
            res[0][1] = intervals[i][1];
            }
            i++;

        }

        list.add(new Pair<>(res[0][0],res[0][1]));

        int[][] ans = new int[list.size()][2];
        i = 0;

        for(Pair<Integer, Integer> p : list)
        {
            ans[i][0] = p.getKey();
            ans[i][1] = p.getValue();
            i++;
        }

        return ans;
        
    }
}
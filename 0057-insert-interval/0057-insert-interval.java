class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

            while(i < n && intervals[i][1] < newInterval[0])
            {
                list.add(new Pair<>(intervals[i][0], intervals[i][1]));
                i++;
            }

            while(i < n && intervals[i][0] <= newInterval[1])
            {
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
            }

            list.add(new Pair<>(newInterval[0],newInterval[1]));

            while(i < n)
            {
                list.add(new Pair<>(intervals[i][0], intervals[i][1]));
                i++;
            }
        

        int[][] res = new int[list.size()][2];

        i = 0;
        for(Pair<Integer, Integer> p : list)
        {
            res[i][0] = p.getKey();
            res[i][1] = p.getValue();
            i++;
        }

        return res;
    }
}
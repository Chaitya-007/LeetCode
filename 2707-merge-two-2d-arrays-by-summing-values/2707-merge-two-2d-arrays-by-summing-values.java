class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();

        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i][0]))
            {
                map.put(nums1[i][0], map.get(nums1[i][0]) + nums1[i][1]);
            }
            else
            {
                map.put(nums1[i][0], nums1[i][1]);
            }
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i][0]))
            {
                map.put(nums2[i][0], map.get(nums2[i][0]) + nums2[i][1]);
            }
            else
            {
                map.put(nums2[i][0], nums2[i][1]);
            }
        }

        int[][] ans = new int[map.size()][2];
        int ind = 0;

        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            ans[ind][0] = e.getKey();
            ans[ind][1] = e.getValue();
            ind++;
        }

        return ans;
    }
}
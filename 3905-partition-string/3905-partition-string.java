class Solution {
    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        int n = s.length();
        int l = 0;
        int r = 0;

        while(r < n)
            {
                StringBuilder sb = new StringBuilder(s.substring(l,r+1));

                if(!set.contains(sb.toString()))
                {
                    set.add(sb.toString());
                    ans.add(sb.toString());
                    l = r + 1;
                }

                r++;
            }

        return ans;
    }
}
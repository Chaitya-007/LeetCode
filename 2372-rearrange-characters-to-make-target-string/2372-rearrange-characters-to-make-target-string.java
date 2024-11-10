class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];
        Arrays.fill(sarr,0);
        Arrays.fill(tarr,0);

        for(char ch : s.toCharArray())
        {
            int ind = (int)(ch - 'a');
            sarr[ind] = sarr[ind] + 1;
        }

        for(char ch : target.toCharArray())
        {
            int ind = (int)(ch - 'a');
            tarr[ind] = tarr[ind] + 1;
        }

        int cnt = Integer.MAX_VALUE;

        for(int i = 0; i < target.length(); i++)
        {
            int ind = (int) (target.charAt(i) - 'a');
            int val = sarr[ind]/tarr[ind];
            if(cnt > val)
            {
                cnt = val;
            }
        }

        return cnt;
    }
}
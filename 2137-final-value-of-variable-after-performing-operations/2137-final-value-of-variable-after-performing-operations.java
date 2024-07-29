class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int cnt = 0;

        for(String str : operations)
        {
            if(str.equals("--X") || str.equals("X--"))
            {
                cnt--;
            }
            else
            {
                cnt++;
            }
        }

        return cnt;
    }
}
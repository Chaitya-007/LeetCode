class Solution {
    public int minBitFlips(int start, int goal) {
        
        int cnt = 0;
        for(int i = 0; i < 31; i++)
        {
            int startBit = (start & (1<<i)) != 0 ? 1 : 0;
            int goalBit = (goal & (1<<i)) != 0 ? 1 : 0;
            
            cnt += ( (startBit ^ goalBit)  != 0 ? 1 : 0);   

        }

        return cnt;
    }
}
class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = (start ^ goal);
        int cnt = Integer.bitCount(xor);
        return cnt;
        
    }
}
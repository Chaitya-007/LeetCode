class Solution {
    public int minimizedStringLength(String s) {
        HashSet<Character> hset = new HashSet<Character>();

        for(char ch : s.toCharArray())
        {
            hset.add(ch);
        }

        return hset.size();
    }
}
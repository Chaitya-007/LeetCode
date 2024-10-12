class Solution {
    public int partitionString(String s) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
            {
                cnt++;
                set.clear();
            }
           
                set.add(s.charAt(i));
            
        }

        return cnt + 1;
        
    }
}
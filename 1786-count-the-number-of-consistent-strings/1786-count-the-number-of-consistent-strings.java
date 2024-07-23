class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        int cnt = 0;
        Set<Character> st = new HashSet<Character>();

        for(int i = 0; i < allowed.length(); i++)
        {
            st.add(allowed.charAt(i));
        }

       for(String word : words)
       {
        boolean flag = true;
        for(int j = 0; j < word.length(); j++)
        {

        // if(!allowed.contains(String.valueOf(words[i].charAt(j))))
        if(!st.contains(word.charAt(j)))
        {
            flag = false;
            break;
        }

        }

        if(flag)
        {
            cnt++;
        }
       } 

       return cnt;
    }
}
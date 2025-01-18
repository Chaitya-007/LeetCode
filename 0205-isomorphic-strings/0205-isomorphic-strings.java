class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
        {
            return false;
        }

        int n = s.length();

        HashMap<Character, Character> hmap = new HashMap<Character, Character> ();


        for(int i = 0; i < n; i++)
        {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if(!hmap.containsKey(original))
            {
                if(!hmap.containsValue(replacement))
                {
                    hmap.put(original,replacement);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                char val = hmap.get(original);
                if(val != replacement)
                {
                    return false;
                }
            }
        }  

        return true; 
    }
}
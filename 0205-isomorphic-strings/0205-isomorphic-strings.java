class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for(int i = 0; i < s.length(); i++)
        {
            char currKey = s.charAt(i);
            char currVal = t.charAt(i);
            if(map.containsKey(currKey))
            {
                if(map.get(currKey) != currVal)
                {
                    return false;
                }
            }
            else
            {
                if(map.containsValue(currVal))
                {
                    return false;
                }

                map.put(currKey,currVal);
            }
        }

        return true;
    }
}
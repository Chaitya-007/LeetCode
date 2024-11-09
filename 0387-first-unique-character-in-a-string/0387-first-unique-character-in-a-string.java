class Solution {
    public int firstUniqChar(String s) {
     Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    int n = s.length();

     for(int i = 0; i < s.length(); i++)
     {
        char ch = s.charAt(i);
        if(map.containsKey(ch))
        {
            map.put(ch, map.get(ch) + 1);
        }
        else
        {
            map.put(ch,1);
        }
     }

     char key = ' ';

     for(Map.Entry<Character, Integer> e : map.entrySet())
     {
        if(e.getValue() == 1)
        {
            key = e.getKey();
            break;
        }
     }

     if(key == ' ')
     {
        return -1;
     }

        for(int i = 0; i < n; i++)
        {
            if(key == s.charAt(i))
            {
                return i;
            }
        }

     return -1;

    }
}
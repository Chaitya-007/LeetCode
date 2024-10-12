class Solution {
    public String sortVowels(String s) {
        String vowel = "aeiouAEIOU";
        String res = "";
        Map<Character,Integer> map = new TreeMap<Character,Integer>();

        for(char itr : s.toCharArray())
        {
            if(vowel.contains(String.valueOf(itr)))
            {
                if(map.containsKey(itr))
                {
                    map.put(itr,map.get(itr) + 1);
                }
                else
                {
                    map.put(itr,1);
                }
                
            }
            
        }

        ArrayList<Character> list = new ArrayList<Character>();
        

        for(Map.Entry<Character, Integer> e : map.entrySet())
        {
            for(int i = 1; i <= e.getValue(); i++)
            {
                list.add(e.getKey());
            }
        }

        int i = 0;

        for(char itr : s.toCharArray())
        {
            if(vowel.contains(String.valueOf(itr)))
            {
                res += list.get(i);
                i++;
            }
            else
            {
                res += itr;
            }
        }


        return res;
    }
}
class Solution {
    public int rearrangeCharacters(String s, String target) {
        

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map_tar = new HashMap<Character, Integer>();

        for(Character ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        System.out.println(map);

        for(Character ch : target.toCharArray())
        {
            map_tar.put(ch, map_tar.getOrDefault(ch,0) + 1);
        }

        System.out.println(map_tar);



         for(int i = 0; i < target.length(); i++)
        {
            char ch = target.charAt(i);
            int ind = (int) (ch - 'a');

            if(map.containsKey(ch))
            {
                int map_val = map.get(ch);
                int tar_val = map_tar.get(ch);
             

            if(map_val >= tar_val)
            {
              
            }
            else
            {
                
               return 0;
            }

            }
            else
            {
                return 0;
            }
        }

        int cnt = Integer.MAX_VALUE;
        boolean flag = false;

        while(true)
        {

        for(int i = 0; i < target.length(); i++)
        {
            char ch = target.charAt(i);
            int ind = (int) (ch - 'a');

            if(map.containsKey(ch))
            {
                int map_val = map.get(ch);
                int tar_val = map_tar.get(ch);
             

            if(map_val >= tar_val)
            {
              
                int rem = (map_val/tar_val);
                if(cnt > rem)
                {
                    cnt = rem;
                }
                int val = (map_val % tar_val);
                map.put(ch,val);
            }
            else
            {
                
                if(cnt != Integer.MAX_VALUE)
                {
                    return cnt;
                }
                else
                {
                    return 0;
                }
            }

            }
            else
            {
                return 0;
            }
        }

        }
    }
}
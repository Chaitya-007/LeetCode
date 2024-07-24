class Solution {
    public String freqAlphabets(String s) {
        
        char ch = 'a';
        int i = 1;
        
        HashMap<String, Character> mp = new HashMap<String, Character>();
        while(ch < 'j')
        {
            String str = String.valueOf(i);
            mp.put(str,ch);
            ch++;
            i++;
        }

        ch = 'j';
        i = 10;

        while(ch <= 'z')
        {
            String str = String.valueOf(i);
            mp.put(str,ch);
            ch++;
            i++;
        }
       

        for(Map.Entry<String, Character> e : mp.entrySet())
        {
            System.out.println(e);
        }

        StringBuilder res = new StringBuilder("");

        for(int j = s.length() - 1; j >= 0; j--)
        {
            if(s.charAt(j) != '#')
            {
                String str = String.valueOf(s.charAt(j));
                res.append(mp.get(str));
            }
            else
            {
                String str = s.substring(j-2,j);
                res.append(mp.get(str));
                j = j - 2;
            }
        }

        res.reverse();

        // System.out.println(cha);
        return res.toString();
    }
}
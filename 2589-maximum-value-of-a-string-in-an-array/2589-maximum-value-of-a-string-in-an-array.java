class Solution {
    public int maximumValue(String[] strs) {
        
        // String str = "0123456789";
        // StringBuilder sb = new StringBuilder("");
        // HashMap<Character> set = new HashMap<Characher>();

        // for(char ch = 'a'; i <= 'z'; i++)
        // {
        //     set.add(ch);
        // }

        int maxo = 0;

        for(String word : strs)
        {
            boolean flag = false;
            for(int i = 0; i < word.length(); i++)
            {
                if('a' <= word.charAt(i) && word.charAt(i) <= 'z')
                {
                    flag = true;
                    break;
                }
            }

            if(flag)
            {
                int value = word.length();
                maxo = Math.max(maxo,value);
            }
            else
            {
                int num = Integer.valueOf(word);
                maxo = Math.max(maxo,num);
            }
        }

        return maxo;
    }
}
class Solution {
    public String oddString(String[] words) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();


        String str = words[0];
        int n = str.length();
        for(int i = 1; i < n; i++)
        {
            int diff = (int) (str.charAt(i) - str.charAt(i-1));
            list1.add(diff);
        }

         str = words[1];

        for(int i = 1; i < n; i++)
        {
            int diff = (int) (str.charAt(i) - str.charAt(i-1));
            list2.add(diff);
        }

         str = words[2];
      
        for(int i = 1; i < n; i++)
        {
            int diff = (int) (str.charAt(i) - str.charAt(i-1));
            list3.add(diff);
        }

        // Comparision 1
        int len = list1.size();
        boolean flag1 = false;
        boolean flag2 = false;

        for(int i = 0; i < len; i++)
        {
            if(list2.get(i) != list1.get(i))
            {
                flag1 = true;
                break;
            }
        }


        if(flag1)
        {
        for(int i = 0; i < len; i++)
        {
            if(list3.get(i) != list2.get(i))
            {
                return words[1];
            }
        }
        return words[0];
        }

        for(int i = 2; i < words.length; i++)
        {
            String temp = words[i];
            for(int j = 1; j < temp.length(); j++)
            {
                int diff = (int)(temp.charAt(j) - temp.charAt(j-1));
                if(diff != list1.get(j-1))
                {
                    return temp;
                }
            }
        }

        return "";
    }
}
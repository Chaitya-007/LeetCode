class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<String> ();
        Set<String> hashset = new HashSet<String>();

        for(int i = 0; i < words.length; i++)
        {
            String str = words[i];
            for(int j = 0; j < words.length; j++)
            {
                if(i != j)
                {
                    String temp = words[j];
                    if(temp.indexOf(str) >= 0)
                    {
                        hashset.add(str);
                    }
                }
            }
        }

        for(String str : hashset)
        {
            list.add(str);
        }

        return list;
    }
}
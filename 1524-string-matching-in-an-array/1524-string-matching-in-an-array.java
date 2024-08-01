class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> list = new LinkedHashSet<String>();
        List<String> result = new ArrayList<String>();
        
        for(int i = 0; i < words.length; i++)
        {
            String str = words[i];
            for(int j = 0; j < words.length; j++)
            {
                if(i != j)
                {
                    if(words[j].contains(str))
                    {
                        list.add(str);
                    }
                }
            }

        }

        for(String sub : list)
        {
            result.add(sub);
        }

        return result;
    }
}
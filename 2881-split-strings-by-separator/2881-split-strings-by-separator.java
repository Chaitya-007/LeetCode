class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<String>();

        for(String str : words)
        {
            StringBuilder sb = new StringBuilder("");

            for(char ch : str.toCharArray())
            {
                if(ch == separator)
                {
                    if(sb.length() != 0)
                    {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                else
                {
                    sb.append(ch);
                }
            }

            if(sb.length() != 0)
            {
                list.add(sb.toString());
            }
        }

        return list;

    }
}
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator)
    {
        List<String> st = new ArrayList<String>();
        // String sep = String.valueOf(separator);

       for(int i = 0; i < words.size(); i++)
       {
        StringBuilder sb = new StringBuilder("");
        String str = words.get(i);

        for(int j = 0; j < str.length(); j++)
        {
            if(str.charAt(j) == separator)
            {
                if(sb.length() > 0)
                {
                st.add(sb.toString());
                sb.setLength(0);
                }
            }
            else
            {
                sb.append(str.charAt(j));
            }
        }

        if(sb.length() > 0)
        {
            st.add(sb.toString());
            sb.setLength(0);
        }

       }

        return st;
    }
}
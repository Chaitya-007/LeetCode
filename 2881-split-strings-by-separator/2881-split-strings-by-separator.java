class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<String>();

        for(String str : words)
        {
            int n = str.length();
            String temp = "";

            for(int i = 0; i < n; i++)
            {
                char ch = str.charAt(i);
                if(ch == separator)
                {
                    if(temp.length() != 0)
                    {
                        list.add(temp);
                        temp = "";
                    }
                }
                else
                {
                    temp += ch;
                }
            }

            if(temp.length() != 0)
            {
                list.add(temp);
            }
        }

        return list;
    }
}
class Solution {
    public String[] divideString(String s, int k, char fill) {

        List<String> list = new ArrayList<String>();

     
        for(int i = 0; i < s.length(); i+=k)
        {
            String t = s.substring(i,Math.min(i+k,s.length()));
            if(t.length() < k)
            {
                while(t.length() < k)
                {
                    t += fill;
                }
            }
            list.add(t);
        }

        String[] sarray = new String[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            sarray[i] = list.get(i);
        }

        return sarray;
    }
}
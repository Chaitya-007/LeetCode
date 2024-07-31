class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<String>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(++cnt == k)
            {
                list.add(sb.toString());
                sb.setLength(0);
                cnt = 0;
            }
            
        }


        while(cnt != 0 && cnt != k)
        {
            sb.append(fill);
            cnt++;
        }

        if(sb.length() > 0)
        {
            list.add(sb.toString());
        }

        System.out.println(list);
        int len = list.size();
        String[] str = new String[len];

        for(int i = 0; i < len; i++)
        {
            str[i] = list.get(i);
        }
        return str;
    }
}
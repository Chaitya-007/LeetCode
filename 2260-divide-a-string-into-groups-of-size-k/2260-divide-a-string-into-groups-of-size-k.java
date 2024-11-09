class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<String>();

        int n = s.length();

        for(int i = 0; i < n; i = i + k)
        {
            String str = s.substring(i,Math.min(n,i+k));
            list.add(str);
        }

        int len = list.size();

        StringBuilder sb = new StringBuilder( list.get(len - 1));

        int val = n%k;

        if(val != 0)
        {

        while(val < k)
        {
            sb.append(fill);
            val++;
        }
        }

        list.set(len - 1, sb.toString());

        String[] arr = new String[list.size()];
        int ind = 0;

        for(String st : list)
        {
            arr[ind] = st;
            ind++;
        }

        return arr;
    }
}
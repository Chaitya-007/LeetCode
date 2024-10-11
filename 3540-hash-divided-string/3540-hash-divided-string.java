class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        int num_of_sub = n/k;

        ArrayList<Character> list = new ArrayList<Character>();        

        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            list.add(ch);
        }

        int i = 0;
        int j = k;
        String res = "";

        for(int t = 1; t <= num_of_sub; t++)
        {
            String str = s.substring(i,j);
            i = i + k;
            j = j + k;
            int sum = 0;
            for(int m = 0; m < str.length(); m++)
            {
                sum += (int)(str.charAt(m) - 'a');
            }

            int ind = sum%26;
            res += list.get(ind);

        }

        return res;
    }
}
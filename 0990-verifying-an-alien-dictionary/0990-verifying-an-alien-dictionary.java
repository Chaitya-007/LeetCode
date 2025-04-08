class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> orderMap = new HashMap<>();

        int cnt = 0;
        for(Character ch : order.toCharArray())
        {
            orderMap.put(ch,cnt);
            cnt++;
        }

        int n = words.length;
        for(int i = 0; i < n - 1; i++)
        {
            StringBuilder sb1 = new StringBuilder(words[i]);
            StringBuilder sb2 = new StringBuilder(words[i + 1]);
            int len = Math.min(sb1.length(),sb2.length());
            boolean flag = true;

            for(int j = 0; j < len; j++)
            {
                if(orderMap.get(sb1.charAt(j)) > orderMap.get(sb2.charAt(j)))
                {

                    return false;
                }
                else if(orderMap.get(sb1.charAt(j)) < orderMap.get(sb2.charAt(j)))
                {
                    flag = false;
                    break;
                }
                else
                {
                    continue;
                }
            }

            if(flag && sb1.length() > sb2.length())
            {
                return false;
            }
        }

        return true;
        
    }
}
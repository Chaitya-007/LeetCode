class Solution {

    public static String hash(String str)
    {
        Set<Character> hset = new TreeSet<Character>();

        StringBuilder sb = new StringBuilder("");

        for(int i = 0;  i < str.length(); i++)
        {
            hset.add(str.charAt(i));
        }

        for(Character ch : hset)
        {
            sb.append(ch);
        }

        return sb.toString();
    }

    public int similarPairs(String[] words) {
        
        Map<String, Integer> hmap = new HashMap<String, Integer>();

        for(int i = 0; i < words.length; i++)
        {
            String hashStr = hash(words[i]);

            if(hmap.containsKey(hashStr))
            {
                hmap.put(hashStr, hmap.get(hashStr) + 1);
            }
            else
            {
                hmap.put(hashStr, 1);
            }

        }

        int sum = 0;

        for(Integer i : hmap.values())
        {
            int val = ((i*(i-1))/2);
            sum += val;
        }

        return sum;
    }
}
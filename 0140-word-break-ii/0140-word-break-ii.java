class Solution {


    public void fun(int ind, List<String> ans, List<String> list, String s, HashSet<String> wordSet)
    {
        if(ind == s.length())
        {
            StringBuilder sb = new StringBuilder("");

            for(int i = 0; i < list.size(); i++)
            {
                if(i == list.size() - 1)
                {
                    sb.append(list.get(i));
                }
                else
                {
                    sb.append(list.get(i));
                    sb.append(" ");
                }
            }

            if(sb.length() != 0)
            {
                ans.add(sb.toString());
            }
            return;
        }


        for(int i = ind; i < s.length(); i++)
        {
            if(wordSet.contains(s.substring(ind, i + 1)))
            {
                list.add(new String(s.substring(ind, i + 1)));
                fun(i + 1, ans, list, s, wordSet);
                list.remove(list.size() - 1);
            }
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();

        fun(0,ans,new ArrayList<>(), s, wordSet);
        return ans;
        
    }
}
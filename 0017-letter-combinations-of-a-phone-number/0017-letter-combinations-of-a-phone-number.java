class Solution {

    public void fun(int ind, String digits, HashMap<Character, List<String>> mpp, StringBuilder sb, List<String> ans)
    {
        if(ind == digits.length())
        {
            if(sb.length() != 0)
            {
            ans.add(sb.toString());
            }
            return;
        }

        for(String str : mpp.get(digits.charAt(ind)))
        {
            sb.append(str);
            fun(ind + 1, digits, mpp, sb, ans);
            sb.deleteCharAt(ind);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<String>();

       
            HashMap<Character, List<String> > mpp = new HashMap<>();

            mpp.put('2', Arrays.asList("a","b","c"));
            mpp.put('3', Arrays.asList("d","e","f"));
            mpp.put('4', Arrays.asList("g","h","i"));
            mpp.put('5', Arrays.asList("j","k","l"));
            mpp.put('6', Arrays.asList("m","n","o"));
            mpp.put('7', Arrays.asList("p","q","r","s"));
            mpp.put('8', Arrays.asList("t","u","v"));
            mpp.put('9', Arrays.asList("w","x","y","z"));

            StringBuilder sb = new StringBuilder("");

            fun(0,digits,mpp,sb,ans);

            return ans;
    }
}
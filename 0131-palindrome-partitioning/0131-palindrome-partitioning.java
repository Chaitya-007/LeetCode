class Solution {

    public boolean isPalin(String temp)
    {
        int l = 0;
        int r = temp.length() - 1;

        while(l < r )
        {
            if(temp.charAt(l) != temp.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public void fun(int ind, String str, List<String> list, List<List<String>> ans)
    {
        if(ind == str.length())
        {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind; i < str.length(); i++)
        {
            if(isPalin(str.substring(ind,i+1)))
            {
                list.add(new String(str.substring(ind,i+1)));
                fun(i + 1, str, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        List<String> list = new ArrayList<>();

        fun(0,s,list,ans);

        return ans;
        
    }
}
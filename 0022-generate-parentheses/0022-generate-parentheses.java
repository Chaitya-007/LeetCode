class Solution {

    public void fun(int op, int clo, List<String> ans, StringBuilder sb)
    {
        if(op == 0 && clo == 0)
        {
            ans.add(new String(sb.toString()));
            return;
        }

        if(op > 0)
        {
            sb.append('(');
            fun(op - 1, clo, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(clo > 0 && clo > op)
        {
            sb.append(')');
            fun(op, clo - 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");

        fun(n,n,ans,sb);
        return ans;
    }
}
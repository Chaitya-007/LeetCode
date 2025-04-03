class Solution {

    public void fun(int op, int clo, List<String> ans, StringBuilder sb)
    {
        if(op == 0 && clo == 0)
        {
            ans.add(new String(sb.toString()));
            return;
        }

        if(op == clo)
        {
            sb.append('(');
            fun(op - 1, clo, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if(op == 0 && clo != 0)
        {
            sb.append(')');
            fun(op, clo - 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append('(');
        fun(op - 1, clo, ans, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        fun(op, clo - 1, ans, sb);
        sb.deleteCharAt(sb.length() - 1);
        return;

        
    }



    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        fun(n,n,ans,sb);
        return ans;
    }
}
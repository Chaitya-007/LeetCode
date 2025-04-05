class Solution {

    public void fun(int ind,  StringBuilder sb, long eval, long residual, List<String> ans, int target, String str)
    {
        if(ind == str.length())
        {
            if(eval == target)
            {
                if(sb.length() != 0)
                {
                    ans.add(new String(sb.toString()));
                }
            }

            return;
        }

        // StringBuilder currStr = new StringBuilder("");
        // long currNum = 0;

        for(int i = ind; i < str.length(); i++)
        {
            if(i > ind && str.charAt(ind) == '0') return;

            StringBuilder currStr = new StringBuilder(str.substring(ind, i + 1));
            long currNum = Long.valueOf(currStr.toString());
            // currStr.append(str.charAt(i));
            // currNum = currNum * 10 + (int)(str.charAt(i) - '0');

            if(ind == 0)
            {
                
                 sb.append(currStr);
                fun(i + 1, sb, currNum, currNum, ans, target, str);
                sb.delete(sb.length() - currStr.length(), sb.length());
               
            }
            else
            {
                sb.append('+');
                sb.append(currStr);
                fun(i + 1, sb, eval + currNum, currNum, ans, target, str);
                sb.delete(sb.length() - currStr.length(), sb.length());
                sb.deleteCharAt(sb.length() - 1);

                sb.append('-');
                sb.append(currStr);
                fun(i + 1, sb, eval - currNum, -currNum, ans, target, str);
                sb.delete(sb.length() - currStr.length(), sb.length());
                sb.deleteCharAt(sb.length() - 1);

                sb.append('*');
                sb.append(currStr);
                fun(i + 1, sb, eval - residual + (residual * currNum), currNum*residual, ans, target, str);
                sb.delete(sb.length() - currStr.length(), sb.length());
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");

        fun(0,sb,0,0,ans,target,num);
        return ans;
        
    }
}
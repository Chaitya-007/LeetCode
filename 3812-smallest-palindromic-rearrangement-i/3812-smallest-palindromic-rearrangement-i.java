class Solution {

    public boolean fun(int ind,StringBuilder sb, String s,boolean vis[],List<String> ans)
    {
        if(ind == s.length())
        {
            StringBuilder s1 = new StringBuilder(sb.toString());
            if(s1.reverse().toString().equals(sb.toString()))
            {
                ans.add(new String(sb.toString()));
                return true;
            }
            return false;
        }

        for(int i = 0; i < s.length(); i++)
            {
                if(i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
                
                if(!vis[i])
                {
                    vis[i] = true;
                    sb.append(s.charAt(i));
                    if(fun(ind+1,sb,s,vis,ans) == true)
                    {
                        return true;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    vis[i] = false;
                }
            }

        return false;
    }
    
    public String smallestPalindrome(String s) {

        int n = s.length();
        // char ch[] = s.toCharArray();
        // StringBuilder temp = new StringBuilder("");
        // Arrays.sort(ch);
        // temp.append(ch);
        // String res = temp.toString();
        // List<String> ans = new ArrayList<>();
        // boolean[] vis = new boolean[n];
        // fun(0,new StringBuilder(""),res,vis,ans);
        // return ans.get(0);

        // char ch[] = s.toCharArray()
        int[] hash = new int[26];
        for(char ch : s.toCharArray())
            {
                hash[(int)(ch - 'a')] += 1;
            }

        char[] res = new char[n];
        int left = 0;
        int right = n - 1;

        for(int i = 0; i < 26; i++)
            {
                while(hash[i] >= 2)
                {
                    res[left] = (char)(i + 'a');
                    left++;
                    res[right] = (char)(i + 'a');
                    right--;
                    hash[i] -= 2;
                }
            }

        
        // Smart Move
        if(left == right)
        {
            for(int i = 0; i < 26; i++)
            {
                while(hash[i] > 0)
                {
                    res[left] = (char)(i + 'a');
                    left++;
                    break;
                }
            }
        }

        return new String(res);

        
    }
}
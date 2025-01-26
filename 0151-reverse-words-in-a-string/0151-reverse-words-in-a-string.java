class Solution {

    public void reverse(char[] ch, int l, int r)
    {
        while(l < r)
        {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }

    public String reverseWords(String s) {

        int n = s.length();
        // String[] temp = s.split(" ");

        // System.out.println(temp);

        // StringBuilder sb = new StringBuilder("");
        // for(String str : temp)
        // {
        //     // System.out.println(str.length());
        //     if(str.length() != 0)
        //     {
        //         sb.append(str);
        //         sb.append(" ");
        //     }

        // }

        List<String> list = new ArrayList<String>();

        int i = 0;

        while(s.charAt(i) == ' ')
        {
            i++;
        }

        StringBuilder sb = new StringBuilder("");

        while(i < n)
        {
            if(s.charAt(i) == ' ')
            {
                if(sb.length() != 0)
                {
                    list.add(sb.toString());  
                }
                sb.setLength(0);
            }
            else 
            {
                sb.append(s.charAt(i));
            }
            i++;
        }

        if(sb.length() != 0)
        {
            list.add(sb.toString());
        }

        int sz = list.size();
        sb.setLength(0);
        for(int j = 0; j < sz; j++)
        {
            if(j == sz - 1)
            {
                sb.append(list.get(j));
            }
            else
            {
                sb.append(list.get(j));
                sb.append(" ");
            }
        }

        char[] arr = sb.toString().toCharArray();


        int start = 0;

        for(int k = 0; k < arr.length ;k++)
        {
            if(arr[k] == ' ')
            {
                reverse(arr,start,k-1);
                start = k + 1;
            }
        }

        reverse(arr,start,arr.length-1);

        sb.setLength(0);


        // StringBuilder sb = new StringBuilder("");
        sb.append(arr);
        
        return sb.reverse().toString();

        // return "";
        
    }
}
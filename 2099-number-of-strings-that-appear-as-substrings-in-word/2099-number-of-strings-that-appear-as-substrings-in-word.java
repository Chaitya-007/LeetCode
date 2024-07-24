class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        int cnt = 0;
        // using stl
        for(String str : patterns)
        {
            // if(word.contains(str))
            if(word.indexOf(str) >= 0)
            {
                cnt++;
            }
        }

        // for(String str : patterns)
        // {
        //     if(str.length() > word.length())
        //     {
        //         continue;
        //     }

        //     boolean flag = false;
        //     int k = 0;
            
        //     for(int i = 0; i < word.length(); i++)
        //     {
        //         if(str.charAt(k) == word.charAt(i))
        //         {
        //             flag = true;
        //             k++;
        //             i++;
        //             while(k < str.length())
        //             {
                        
        //                 if( str.charAt(k) == word.charAt(i))
        //                 {
        //                 i++;
        //                 k++;
        //                 }
        //                 else if(str.charAt(k) != word.charAt(i))
        //                 {
        //                     flag = false;
        //                     break;
        //                 }
        //             }
        //             break;
        //         }
            
        //     }

        //     if(flag)
        //     {
        //         System.out.println(str);
        //         cnt++;
        //     }
        // }

        return cnt;
    }
}
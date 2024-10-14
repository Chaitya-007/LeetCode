class Solution {

     int[] arr = new int[26];
    {Arrays.fill(arr,-1);}

    public int findFun(int x)
    {
        if(arr[x] == -1)
        {
            return x;
        }

        return arr[x] = findFun(arr[x]);
    }


    public  void unionFun(int x,int y)
    {
        x = findFun(x);
        y = findFun(y);

        if(x != y)
        {
            arr[Math.max(x,y)] = Math.min(x,y);
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        for(int i = 0; i < s1.length(); i++)
        {
            unionFun(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        String str = "";

        for(int i = 0; i < baseStr.length(); i++)
        {
            str += (char)(findFun(baseStr.charAt(i) - 'a') + 'a');
        }

        return str;

    }
}
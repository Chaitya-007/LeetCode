class Solution {

    public static void swapArray(int indices[], int element, int index)
    {
        int temp = indices[index];
        indices[index] = indices[element];
        indices[element] = temp;

    }

    

    public String restoreString(String s, int[] indices) {

        StringBuilder sb = new StringBuilder("");
        char[] charray = new char[s.length()];

        for(int i = 0; i < indices.length; i++)
        {
            charray[indices[i]] = s.charAt(i);
        }

        // String str = "";

        // for(char i : charray)
        // {
        //     str += i;
        // }

        sb.append(charray);


        return sb.toString();

    }
}
class Solution {
    public char[][] rotateTheBox(char[][] box) {

        
        int m = box.length;
        int n = box[0].length;
        for(int i = 0; i < box.length; i++)
        {
            for(int j = n-1; j >= 0; j--)
            {
                
                for(int ind = j; ind < n - 1; ind++)
                {

                if(box[i][ind] == '#' && box[i][ind+1] == '.')
                {
                    char temp = box[i][ind];
                    box[i][ind] = box[i][ind+1];
                    box[i][ind+1] = temp;
                }
                }
                
            }
        }

        char[][] arr = new char[n][m];
        for(int i = 0; i < box.length; i++)
        {
            for(int j = 0; j < box[i].length; j++)
            {
               arr[j][i] = box[m-1-i][j];
            }
        }

        return arr;
    }
}
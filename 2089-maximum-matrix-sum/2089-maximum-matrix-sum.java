class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int cntneg = 0;
        long sum = 0;
        int mino = Math.abs(matrix[0][0]);

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] < 0)
                {
                    cntneg++;
                }

                if(mino > Math.abs(matrix[i][j]))
                {
                    mino = Math.abs(matrix[i][j]);
                }

                sum += Math.abs(matrix[i][j]);
            }
        }

        if(cntneg%2 == 0)
        {
            return sum;
        }

        return sum - (2*mino);



    }
}
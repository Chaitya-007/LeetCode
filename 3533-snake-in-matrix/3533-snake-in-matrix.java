class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int result = 0;

        for(String str : commands)
        {
            if(str.equals("RIGHT"))
            {
                result++;
            }
            else if(str.equals("LEFT"))
            {
                result--;
            }
            else if(str.equals("UP"))
            {
                result -= n;
            }
            else
            {
                result += n;
            }
        }

        return result;
    }
}
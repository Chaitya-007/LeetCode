class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        int n = s.length();

        String str = "IV IX XL XC CD CM";

        for(int i = n-1; i >= 0;)
        {
            if(i - 1  >= 0 )
            {
                char curr = s.charAt(i);
                char prev = s.charAt(i-1);
            StringBuilder sb = new StringBuilder("");

                sb.append(prev);
                sb.append(curr);

                if(str.contains(sb.toString()))
                {
                    int val = (map.get(curr)) - (map.get(prev));
                    sum += val;
                    i = i - 2;
                }
                else
                {
                    sum += (map.get(curr));
                    i--;

                }
            }
            else
            {
                char curr = s.charAt(i);
                int val = map.get(curr);
                sum += val;
                i--;
            }

            System.out.println("i = " + i + " at sum = " + sum );
        }

        return sum;
    }
}
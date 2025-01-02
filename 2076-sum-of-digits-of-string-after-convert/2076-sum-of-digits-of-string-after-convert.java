class Solution {

    public static int convert(String s)
    {
        int sum = 0;
        // StringBuilder sb = new StringBuilder

        for(char ch : s.toCharArray())
        {
            int val = (int) ((ch - 'a') + 1);

            if(val > 9)
            {
                
                int add = 0;
                while(val > 0)
                {
                    add += (val%10);
                    val = val/10;
                }
                val = add;
            }
            sum += val;
        }

        return sum;
    }

    public int getLucky(String s, int k) {
        
        // Transform 1 done
        int num = convert(s);
        k--;
        System.out.println(num);
        int sum = 0;

        while(k > 0)
        {
            k--;

            while(num > 0)
            {
                int rem = num%10;
                num = num/10;
                sum += rem;
            }

            num = sum;
            sum = 0;

        }

        return num;


    }
}
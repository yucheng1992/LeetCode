class ConvertIntegerAToIntegerB {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            if ((a&1) != (b&1)) {
                res++;
            }
            a = a >> 1;
            b = b >> 1;
        }
        return res;
    }
};



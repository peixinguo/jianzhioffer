public class Q10_Fibonacci {

    public static void main(String[] args) {
        test(0, 0);
        test(1, 1);
        test(2, 1);
        test(3, 2);
        test(4, 3);
        test(5, 5);
        test(6, 8);
        test(7, 13);
        test(8, 21);
        test(9, 34);
        test(10, 55);
        test(40, 102334155);
    }

    private static long fibonacci(int n){

        if (n == 0){
            return 0;
        }

        if (n==1){
            return 1;
        }

        long fibOne = 0;
        long fibTwo = 1;
        long fibThree = 0;

        for (int i = 1; i < n; i++) {
            fibThree = fibOne + fibTwo;

            fibOne = fibTwo;
            fibTwo = fibThree;
        }

        return fibThree;
    }

    // ====================测试代码====================
    private  static void test(int n, int expected)
    {
        if(fibonacci(n) == expected)
            System.out.println("Test for "+ n +" in solution1 passed.");
    }
}

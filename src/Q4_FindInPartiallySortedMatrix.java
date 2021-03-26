
// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class Q4_FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static boolean find(int[][] matrix, int rows, int columns, int number) {

        if (matrix == null || matrix.length <= 0 || columns <=0) {
            return false;
        }

        boolean found = false;
        int row = 0;
        int column = columns - 1;

        while(row < rows && column >=0){
            if (matrix[row][column] == number){
                found = true;
                break;
            }

            if (matrix[row][column] > number){
                column--;
            }else if (matrix[row][column] < number){
                row++;
            }

        }
        return found;
    }

    /**
     * 测试代码
     */
    public static void test(String testName, int[][] matrix, int rows, int columns, int number, boolean expected){
        if (testName != null &&!testName.isEmpty()){
            System.out.println(testName);
        }

        boolean result = find(matrix, rows, columns, number);
        if (result == expected){
            System.out.println("Passed.");
        }else {
            System.out.println("Failed.");
        }
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数在数组中
    private static void test1(){
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test1", matrix,4 ,4 ,7, true);
    }
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数不在数组中
    private static void test2(){
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        test("Test2", matrix,4 ,4 ,5, false);
    }


}

/**
 * 数组中重复数字
 */
public class Question3 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,6,7};
        System.out.println(duplicate(arr));
    }

    /**
     *
     * @param numbers
     * @return 返回-1为查找失败
     */
    private static int duplicate(int[] numbers){
        if (numbers == null || numbers.length <= 0){
            return -1;
        }

        for (int number : numbers) {
            if (number < 0 || number >= numbers.length) {
                return -1;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            while(numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    return numbers[i];
                }else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }

        return -1;
    }

    
}

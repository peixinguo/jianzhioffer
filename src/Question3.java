/**
 * 数组中重复数字
 */
public class Question3 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,6,7};
        System.out.println(duplicate(arr));
        System.out.println(duplicate2(arr,1,7));
        System.out.println(duplicate3(arr));
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

    /**
     * 不修改原数组找出重复的数字
     * 递归方式
     * @param numbers 输入数组
     * @param minNum
     * @param maxNum
     * @return 查找不到返回-1
     */
    private static int duplicate2(int[] numbers, int minNum, int maxNum){

        if (numbers == null || numbers.length <= 0){
            return -1;
        }

        if (minNum+1 == maxNum){
            int count = 0;
            for (int i:numbers) {
                if (i == minNum){
                    count++;
                }
            }
            if (count > 1){
                return minNum;
            }else {
                return maxNum;
            }
        }


        int mid = (minNum + maxNum)/2;
        int countFront = 0;
        int countBehind = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]>= minNum && numbers[i] <= mid){
                countFront++;
            }else if(numbers[i] > mid && numbers[i] <= maxNum){
                countBehind++;
            }
        }
        if (countFront > (mid-minNum+1)){
            return duplicate2(numbers, minNum, mid);
        }else {
            return duplicate2(numbers,mid+1, maxNum);
        }


    }

    /**
     * 不修改原数组找出重复的数字
     * 迭代方式
     * @param numbers
     * @return
     */
    private static int duplicate3(int[] numbers){
        if (numbers == null || numbers.length <= 0){
            return -1;
        }

        int start = 1;
        int end = numbers.length - 1;
        while(end >= start){
            int middle = (start + end)/2;
            int count = countRange(numbers, start, middle);

            if (start == end){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }

            if (count > (middle -start + 1)){
                end = middle;
            }else{
                start = middle + 1;
            }

        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int end){
        if (numbers == null){
            return 0;
        }
        int count  = 0;
        for (int i: numbers) {
            if (i >= start && i <= end){
                count++;
            }
        }
        return count;
    }

}

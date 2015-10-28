public class CheckPreorder {
    public static boolean preorderJudge(int[] array){
        if (array == null || array.length < 1){
            return false;
        }
        return helper(array, 0, array.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(int[] array, int start, int end, int min, int max){
        if (start > end){
            return true;
        }
        if (start == end){
            return array[start] > min && array[start] < max;
        }
        int root = array[start], i = start + 1;
        if (root > max || root < min){
            return false;
        }
        for (; i <= end; i++){
            if (array[i] > root){
                break;
            }
        }
        i -= 1;
        return helper(array, start + 1, i, min, root) && helper(array, i + 1, end, root, max);
    }
}

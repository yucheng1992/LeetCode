public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        num = mergeSort(num);
        for (int i = 0; i < num.length; i++) {
            res.append(num[i]);
        }
        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
    public boolean isBigger(int num1, int num2) {
        int bit1 = (int)Math.log10(num1);
        int bit2 = (int)Math.log10(num2);
        int i = 0;
        int start1 = num1 == 0 ? 0 : num1 / (int)Math.pow(10, bit1);
        int start2 = num2 == 0 ? 0 : num2 / (int)Math.pow(10, bit2);
        int n1 = 0;
        int n2 = 0;
        for (; i <= Math.max(bit1, bit2); i++) {
            if (i > bit2) {
                while (i <= bit1) {
                    n1 = num1 / (int)Math.pow(10, bit1 - i);
                    num1 = num1 - n1 * (int)Math.pow(10, bit1 - i);
                    if (n1 > start2 && n1 > n2) {
                        return true;
                    } else if (n1 < start2 || n1 < n2) {
                        return false;
                    }
                    i++;
                }
                return true;
            } else if (i > bit1) {
                while (i <= bit2) {
                    n2 = num2 / (int)Math.pow(10, bit2 - i);
                    num2 = num2 - n2 * (int)Math.pow(10, bit2 - i);
                    if (n2 > start1 && n2 > n1) {
                        return false;
                    } else if (n2 < start1 || n2 < n1) {
                        return true;
                    }
                    i++;
                }
                return true;
            }
            n1 = num1 / (int)Math.pow(10, bit1 - i);
            n2 = num2 / (int)Math.pow(10, bit2 - i);
            if (n1 > n2) {
                return true;
            } else if (n1 < n2) {
                return false;
            } else {
                num1 = num1 - n1 * (int)Math.pow(10, bit1 - i);
                num2 = num2 - n2 * (int)Math.pow(10, bit2 - i);

            }
        }
        return true;
    }
    public int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int half = arr.length/2;
        int[] arr1 = new int[half];
        int[] arr2 = new int[arr.length-half];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, half, arr2, 0, arr2.length);
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        return mergeSortSub(arr1,arr2);
    }
 
    private int[] mergeSortSub(int[] arr1,int[] arr2){
        int[] result = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(true){
            if(isBigger(arr1[i], arr2[j])){
                result[k] = arr1[i];
                if(++i > arr1.length - 1){
                    break;
                }
            } else{
                result[k] = arr2[j];
                if(++j>arr2.length-1){
                    break;
                }
            }
            k++;
        }
        for(; i<arr1.length; i++){
            result[++k] = arr1[i];
        }
        for(; j<arr2.length; j++){
            result[++k] = arr2[j];
        }
        return result;
    }
}

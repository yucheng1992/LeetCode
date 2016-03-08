public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        //swapPrev stores the index of the number which is the first number that is bigger than its previous number.
        int swapPrev = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i-1]) {
                swapPrev = i;
                break;
            }
        }

        //If the swapPrev is still -1, it means that the num is in a non-increasing order, os we just need to sort the array.
        if (swapPrev != -1) {
            Arrays.sort(num, swapPrev, num.length);
            //toSwap stores the index of the number that need to be swapped with number before swapPrev.
            int toSwap = -1;
            for (int i = swapPrev; i<num.length; i++) {
                if (num[i] > num[swapPrev-1]) {
                    toSwap = i;
                    break;
                }
            }
            //swap the two target numbers.
            int temp = num[swapPrev-1];
            num[swapPrev-1] = num[toSwap];
            num[toSwap] = temp;
        } else {
            Arrays.sort(num);
        }
    }
}

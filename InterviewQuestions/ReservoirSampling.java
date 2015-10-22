public class ReservoirSampling {
    public int getRandom(int[] arr) {
        int res = arr[0];
        Random generator = new Random();
        for (int i = 1; i < arr.length; i++) {
            int j = generator.nextInt(i);
            if (j == 1) {
                res = arr[i];
            }
        }
        return res;
    }
}

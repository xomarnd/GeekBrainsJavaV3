import java.util.Arrays;

class Main {
    private static int LASTNUMBERS = 4;
    private static int NUMBERSONE = 1;
    private static int NUMBERSTWO = 4;


    public static int[] afterLastNumbers(int[] arr) throws RuntimeException {
        int n = 0;
        String str = Arrays.toString(arr);
        if (str.indexOf(String.valueOf(4)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == LASTNUMBERS) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("Error: 4N4 - \"" + LASTNUMBERS + "\" not found");
        }
    }
    public static boolean searchPairNumbers(int[] arr) {
        boolean one = false, two = false;
        for (int value : arr) {
            if (value == NUMBERSONE) one = true;
            else if (value == NUMBERSTWO) two = true;
            else return false;
        }
        return one && two;
    }
}

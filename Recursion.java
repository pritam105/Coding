import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {
        int[] arr = array1toN(20);
        int[] arr1 = {6, 7};
        String str = "tenet";
//        arr = Arrays.copyOf(arr, 6);
//        System.arraycopy(arr1, 0, arr, 1, arr1.length);
//        reverseArr(arr, 0, 4);
        reverseArr3(arr);
        System.out.println(palindrome(str));
        System.out.println(Arrays.toString(arr));
//        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void printName(int n) {
        if (n == 0)
            return;
        System.out.println("Pritam");
        printName(n - 1);
    }

    private static void printN(int n) {
        if (n == 0)
            return;
        printN(n - 1);
        System.out.println(n);
    }

    private static int sum(int n) {
        if (n > 0)
            return n + sum(n - 1);
        return n;
    }

    private static int[] array1toN(int x) {
        if (x > 1) {
            int[] arr;
            arr = Arrays.copyOf(array1toN(x - 1), x);
            arr[x - 1] = x;
            return arr;
        }
        return new int[]{1};
    }

    /*
    Reverse an array with recursion. Function modifies the array passed.
     */
    private static void reverseArr(int[] arr, int start, int end) {
        if (end - start < 2)
            return;
        int temp;
        temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
        reverseArr(arr, start + 1, end - 1);

    }

    /*
    Reverse an array with recursion and just the array as argument.
    Function modifies the array passed and returns the reversed array
     */
    private static int[] reverseArr2(int[] arr) {
        if (arr.length < 2)
            return arr;
        int temp;
        temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        int[] reversedArray = reverseArr2(Arrays.copyOfRange(arr, 1, arr.length - 1));

        if (reversedArray.length != 0)
            System.arraycopy(reversedArray, 0, arr, 1, reversedArray.length);

        return arr;
    }

    /*
    Reverse an array with recursion and just the array as argument.
    Function modifies the array passed with void return type.
     */
    private static void reverseArr3(int[] arr) {
        if (arr.length < 2)
            return;
        int temp;
        temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        int[] subArr = Arrays.copyOfRange(arr, 1, arr.length - 1);
        reverseArr3(subArr);

        if (subArr.length != 0)
            System.arraycopy(subArr, 0, arr, 1, subArr.length);
    }

    private static boolean palindrome(String str){

        char[] strChar = str.toCharArray();
        if(strChar.length<2)
            return true;
        if(strChar[0] == strChar[strChar.length-1])
            return palindrome(String.valueOf(Arrays.copyOfRange(strChar, 1, strChar.length-1)));
        return false;
    }
}
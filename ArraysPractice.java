import java.sql.SQLOutput;
import java.util.Arrays;

public class ArraysPractice {


    public static void main(String[] args){
        int[] arr = PracticeUtils.createArray(6);
        System.out.println(Arrays.toString(arr));
        System.out.println("Max: "+ secondLargest(new int[]{5,5,4,3,2,1}));
    }

    private static int secondLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) max = j;
        }

        for(int j : arr){
            if(j != max && j > max2) max2 = j;
        }

        if(max2 == Integer.MIN_VALUE) max2 = -1;

        return max2;
    }
}

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;

public class ArraysPractice {


    public static void main(String[] args){
        int[] arr = PracticeUtils.createArray(6);

        frequency(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Max: "+ secondLargest(new int[]{5,5,4,3,2,1}));
    }

    private static int secondLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        /*
        Find second largest in 2 traversals
         */
//        for (int j : arr) {
//            if (j > max) max = j;
//        }
//
//        for(int j : arr){
//            if(j != max && j > max2) max2 = j;
//        }
//
//        if(max2 == Integer.MIN_VALUE) max2 = -1;
//
//        return max2;

        /*
        Find second largest in one traversal
         */
        for(int i : arr){
            if(i>max){
                max2 = max;
                max = i;
            }
            else if (i > max2 && i != max) max2 = i;
        }
        return max2;
    }

    private static void frequency(int[] arr){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i : arr){
            if(frequencyMap.containsKey(i)) frequencyMap.put(i, frequencyMap.get(i) + 1);
            else frequencyMap.put(i, 1);
        }
        System.out.println(frequencyMap.entrySet());
    }
}

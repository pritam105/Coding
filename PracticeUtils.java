import java.util.Random;
public class PracticeUtils {
    public static int[] createArray(int size){
        Random rd = new Random();
        int[] arr = new int[size];

        for(int i=0; i<size; i++)
            arr[i] = rd.nextInt(100);

        return arr;
    }
}

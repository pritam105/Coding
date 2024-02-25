import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ArraysPractice {


    public static void main(String[] args){
//        int[] arr = PracticeUtils.createArray(10);
        int[] arr = new int[]{16,1,64,32,5,43,21,16,32,5,5};
        testing(arr);
        arr = removeDuplicatesInPlace(arr);
//        System.out.println("After removing duplicates " + Arrays.toString(arr));

        /*
        pass by value trial
         */
        Dog dog = new Dog();
        dog.setName("tommy");
        foo(dog);
        System.out.println(dog.getName());
    }

    private static void foo(Dog d){
        d.setName("jimmy");
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

    private static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int base = arr[0];
        int length = 1;

        if(n ==1) return length;

        for(int i=1; i<n; i++){
            if(arr[i] == base) continue;
            else{
                length++;
                base = arr[i];
            }
        }
        return length;
    }

    private static int[] removeDuplicatesInPlace(int[] arr){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int i : arr){
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }

        int i = 0;
        arr = Arrays.copyOf(arr, map.size());

        for(Map.Entry<Integer, Integer> j : map.entrySet()){
            arr[i] = j.getKey();
            i++;
        }
        return arr;
    }

    private static void testing(int[] arr){
        /*
        Using Streams API
         */
        Set<Integer> set = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        /*
        Using loop
         */
        for(int i :arr){
            set.add(i);
        }

        System.out.println(set);
    }
}

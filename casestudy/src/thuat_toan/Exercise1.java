package thuat_toan;

import java.util.*;

public class Exercise1 {
    public boolean checkArr(int[] arr) {

        Set<Integer> arrayResult = new HashSet<>();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
        }
        for (int i = 0; i < array.size(); i++) {
            int count=0;
            for (int j = 0; j < array.size(); j++) {
                if (array.get(i) == array.get(j)){
                    count++;
                }
            }
            arrayResult.add(count);
        }
        if (arrayResult.size() ==1){
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        int[] arr1 = {1,2,1,2};
        int[] arr2 = {1,2,2,3,1,3,1,3};
        int[] arr3 = {4, 3, 2, 1, 4, 2, 3, 1, 1};
        int[] arr4 = {4, 3, 2, 1, 4, 2, 3, 1};
        System.out.println(exercise1.checkArr(arr1));
        System.out.println(exercise1.checkArr(arr2));
        System.out.println(exercise1.checkArr(arr3));
        System.out.println(exercise1.checkArr(arr4));
    }
}


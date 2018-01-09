package Sorting;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Vetriselvan on 27-12-2017.
 * 14.2 Merge two Sorted Arrays
 */
public class MergeTwoSortedSubArray {
    public static void main(String[] args) {
        int[] sortedArray1 = {2,3,3,5,5,6,7,7,8,12};
        int[] sortedArray2 = {5,5,6,8,8,9,10,10};
        int[] resultArray = new int[sortedArray1.length + sortedArray2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < sortedArray1.length && j < sortedArray2.length) {
            resultArray[k++] = (sortedArray1[i] < sortedArray2[j]) ?
                    sortedArray1[i++] : sortedArray2[j++];
        }
        while(i < sortedArray1.length)
            resultArray[k++] = sortedArray1[i++];
        while(j < sortedArray2.length)
            resultArray[k++] = sortedArray2[j++];
        printArray(resultArray);
    }

    static void printArray(int[] resultArray) {
        for(int num : resultArray) {
            System.out.print(num);
            System.out.print(' ');
        }
    }
}

package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Vetriselvan on 27-12-2017.\
 * 14.1 Intersect two Sorted Array (Application - Search Engine Inverted Index)
 */
public class IntersectTwoSortedArray {
    public static void main(String[] args) {
        int[] sortedArray1 = {2,3,3,5,5,6,7,7,8,12};
        int[] sortedArray2 = {5,5,6,8,8,9,10,10};
        List<Integer> sortedList1 = Arrays.asList(2,3,3,5,5,6,7,7,8,12);
        List<Integer> sortedList2 = Arrays.asList(5,5,6,8,8,9,10,10);
        IntersectTwoSortedArray intersectTwoSortedArray = new IntersectTwoSortedArray();
        List<Integer> intersectedElements = intersectTwoSortedArray.getInterSectedArray(sortedArray1, sortedArray2);
        for(Integer x:  intersectedElements) {
            System.out.println(x);
        }
        List<Integer> intersectedListElements = intersectTwoSortedArray.getIntersectedArray(sortedList1, sortedList2);
        for(Integer y: intersectedListElements) {
            System.out.println(y);
        }
    }

    /**
     * Time Complexity is O(mn)
     * m is the number of elements in sortedArray1
     * n is the number of elements in sortedArray2
     * @param sortedArray1
     * @param sortedArray2
     * @return
     */
    private List<Integer> getInterSectedArray(int[] sortedArray1, int[] sortedArray2) {
        List<Integer> intersectionElements = new ArrayList<Integer>();
        for(int i=0; i < sortedArray1.length; i++) {
            if(i == 0 || sortedArray1[i] != sortedArray1[i-1]) {
                for(int a : sortedArray2) {
                    if(sortedArray1[i] == a) {
                        intersectionElements.add(a);
                        break;
                    }
                }
            }
        }
        return intersectionElements;
    }

    /**
     * Time Complexity is o(mlogn)
     * m is the number of elements in first sorted array
     * n is the number of elements in second sorted array
     * @param sortedArray1
     * @param sortedArray2
     * @return
     */
    private List<Integer> getIntersectedArray(List<Integer> sortedArray1, List<Integer> sortedArray2) {
        List<Integer> intersectionElements = new ArrayList<Integer>();
        for(int i=0; i < sortedArray1.size(); i++) {
            if((i == 0 || sortedArray1.get(i) != sortedArray1.get(i-1)) && Collections.binarySearch(sortedArray2, sortedArray1.get(i)) >= 0) {
                intersectionElements.add(sortedArray1.get(i));
            }
        }
        return intersectionElements;
    }
}

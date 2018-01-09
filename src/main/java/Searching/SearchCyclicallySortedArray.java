package Searching;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 12.3 Search Cyclically Sorted Array
 *
 */
public class SearchCyclicallySortedArray {
    public static void main(String[] args) {
        int[] array = { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 };
        SearchCyclicallySortedArray searchCyclicallySortedArray = new SearchCyclicallySortedArray();
        System.out.println(searchCyclicallySortedArray.searchSmallest(array));
    }

    private int searchSmallest(int[] array) {
        int left = 0, right = array.length - 1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(array[mid] < array[mid+1] && array[mid] < array[mid-1]) {
                return array[mid];
            } else if(array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}

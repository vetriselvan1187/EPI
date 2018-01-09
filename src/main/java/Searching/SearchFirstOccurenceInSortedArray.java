package Searching;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 12.1 Search First Occurrence of K in sorted Array
 * Time Complexity o(logn)
 */

public class SearchFirstOccurenceInSortedArray {
    public static void main(String[] args) {
        int[] array = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
        SearchFirstOccurenceInSortedArray searchFirstOccurenceInSortedArray = new SearchFirstOccurenceInSortedArray();
        int firstOccurence = searchFirstOccurenceInSortedArray.searchFirstOccurenceofK(array, 285);
        System.out.println("first Occurence of K is  at position "+firstOccurence);
    }

    private int searchFirstOccurenceofK(int[] array, int k) {
        int left = 0, right = array.length-1;
        int result = -1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(array[mid] < k) {
                left = mid + 1;
            } else if(array[mid] == k) {
                result = mid;
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

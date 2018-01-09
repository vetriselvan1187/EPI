package Searching;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 12.2 Search Sorted array entry equal to its index
 *
 */
public class SearchEntryEqualToItsIndex {
    public static void main(String[] args) {
        SearchEntryEqualToItsIndex searchEntryEqualToItsIndex = new SearchEntryEqualToItsIndex();
        int[] array = {-2, 0, 2, 3, 6, 7, 9};
        int entry = searchEntryEqualToItsIndex.searchEntryEqualtoIndex(array);
        System.out.println(entry);
    }

    private int searchEntryEqualtoIndex(int[] array) {
        int left = 0, right = array.length-1;
        while(left <=  right) {
            int mid = left + (right-left)/2;
            int difference = array[mid]-mid;
            if(difference == 0) {
                return mid;
            } else if(difference > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

package Searching;

/**
 * Created by Vetriselvan on 31-12-2017.
 * Search Given Element in Sorted Array
 * Time Complexity is o(logn)
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();
        int position = binarySearch.bSearch(sortedArray, 5);
        System.out.println(position);
    }

    private int bSearch(int[] sortedArray, int x) {
        int left = 0;
        int right = sortedArray.length-1;

        while(left <= right) {
            int mid = (left+(right-left))/2;
            if(sortedArray[mid] == x)
                return mid;
            else if(sortedArray[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}

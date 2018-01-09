package Searching;

/**
 * Created by Vetriselvan on 25-12-2017.
 * 12.6 Search Element in 2D Sorted Array
 */
public class SearchElementInSortedArray {
    public static void main(String[] args) {
        int[][] array = {   { -1, 2, 4, 4, 6 },
                            { 1, 5, 5, 9, 21 },
                            { 3, 6, 6, 9, 22 },
                            { 3, 6, 8, 10, 24 },
                            { 6, 8, 9, 12, 25 },
                            { 8, 10, 12, 13, 40 }
                        };
        SearchElementInSortedArray searchElementInSortedArray = new SearchElementInSortedArray();
        System.out.println(searchElementInSortedArray.searchElement(array, 100));
    }

    private boolean searchElement(int[][] array, int x) {
        int row = 0, col = array[0].length - 1;
        while(row < array[0].length && col >= 0) {
            if(array[row][col] == x)
                return true;
            else if(array[row][col] < x)
                ++row;
            else if(array[row][col] > x)
                --col;
        }
        return false;
    }
}

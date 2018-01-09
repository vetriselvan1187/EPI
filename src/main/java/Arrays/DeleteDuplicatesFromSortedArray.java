package Arrays;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 6.5 Delete duplicates from sorted array
 * Time Complexity is o(n) - Space Complexity is o(1)
 */

public class DeleteDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {1,2,2,2,3,4,4,5,6,6,6,6,7};
        DeleteDuplicatesFromSortedArray deleteDuplicatesFromSortedArray = new DeleteDuplicatesFromSortedArray();
        deleteDuplicatesFromSortedArray.deleteDuplicates(sortedArray);
        for(int a : sortedArray) {
            System.out.print(a);
            System.out.print(' ');
        }
    }

    private void deleteDuplicates(int[] sortedArray) {
        int j = 0;
        for(int i=0; i < sortedArray.length-1 ; i++) {
            if(sortedArray[i] != sortedArray[i+1]) {
                sortedArray[j+1] = sortedArray[i+1];
                j++;
            }
        }
        j++;
        while(j < sortedArray.length) {
            sortedArray[j++] = 0;
        }
    }
}

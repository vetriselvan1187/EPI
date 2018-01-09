package DP;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vetriselvan on 07-01-2018.
 * 17.12 Find the Longest Non Decreasing SubSequence
 *
 */
public class LongestNonDedcreasingSubSequence {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 19);
        LongestNonDedcreasingSubSequence longestNonDedcreasingSubSequence = new LongestNonDedcreasingSubSequence();
        System.out.println();
        System.out.println(longestNonDedcreasingSubSequence.findLongestNonDescreasingSubsequenceLength(numberList));
    }

    //1, 1, 2, 3, 2, 3, 3, 4, 5
    private int findLongestNonDescreasingSubsequenceLength(List<Integer> numbersList) {
        Integer[] maxLength = new Integer[numbersList.size()];
        Arrays.fill(maxLength, 1);
        for(int i = 1; i < numbersList.size(); i++) {
            for(int j=0; j < i; j++) {
                if (numbersList.get(i) >= numbersList.get(j)) {
                    maxLength[i] = Math.max(maxLength[i], 1 + maxLength[j]);
                }
            }
        }
        for(int i = 0; i < maxLength.length; i++) {
            System.out.print(maxLength[i]+" ");
        }
        return Collections.max(Arrays.asList(maxLength));
    }
}

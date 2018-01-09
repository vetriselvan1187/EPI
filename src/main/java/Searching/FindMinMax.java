package Searching;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 12.7 Find the Min and Max Simultaneously
 *
 */
public class FindMinMax {
    private static class MinMax {
        public Integer min;
        public Integer max;

        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        private static MinMax minMax(Integer a, Integer b) {
           return (b-a<0) ? new MinMax(b, a) : new MinMax(a, b);
        }
    }

    public static void main(String[] args) {
        FindMinMax findMinMax = new FindMinMax();
        List<Integer> arrays = Arrays.asList(1, 10, 11, 100, 50, 65, 34);
        MinMax minMax = findMinMax.findMinMax(arrays);
        System.out.println("min "+minMax.min+" max "+minMax.max);
    }

    private MinMax findMinMax(List<Integer> A) {
        if(A.size() <= 1) {
            return new MinMax(0, 0);
        }
        MinMax globalMinMax = MinMax.minMax(A.get(0), A.get(1));
        for(int i=2; i+1 < A.size(); i += 2) {
            MinMax localMinMax = MinMax.minMax(A.get(i), A.get(i+1));
            globalMinMax = new MinMax(Math.min(globalMinMax.min, localMinMax.min), Math.max(globalMinMax.max, localMinMax.max));
        }
        if(A.size()%2 != 0) {
            globalMinMax = new MinMax(Math.min(globalMinMax.min, A.get(A.size()-1)), Math.max(globalMinMax.max, A.get(A.size()-1)));
        }
        return globalMinMax;
    }
}

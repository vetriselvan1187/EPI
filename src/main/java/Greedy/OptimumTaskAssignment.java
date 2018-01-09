package Greedy;

import Primitives.ParityBits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vetriselvan on 06-01-2018.
 * 18.1 Compute an Optimum Assignment Of Tasks
 *  Time Complexity O(nlogn)
 */
public class OptimumTaskAssignment {
     static class PairedTasks {
        Integer task1;
        Integer task2;

        public PairedTasks(Integer task1, Integer task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        @Override
        public String toString() {
            return this.task1 + " " +this.task2;
        }
    }

    public static void main(String[] args) {
        List<Integer> taskDurations = Arrays.asList(5,2,1,6,4,4);
        OptimumTaskAssignment optimumTaskAssignment = new OptimumTaskAssignment();
        List<PairedTasks> optimumTaskList = optimumTaskAssignment.getOptimumAssignment(taskDurations);
        for(PairedTasks task : optimumTaskList) {
            System.out.println(task);
        }
    }

    private List<PairedTasks> getOptimumAssignment(List<Integer> taskDurations) {
        Collections.sort(taskDurations);
        List<PairedTasks> optimumtaskList = new ArrayList<PairedTasks>();

        for(int i=0,j = taskDurations.size()-1; i < j; ++i, --j ) {
            optimumtaskList.add(new PairedTasks(taskDurations.get(i), taskDurations.get(j)));
        }
        return optimumtaskList;
    }
}

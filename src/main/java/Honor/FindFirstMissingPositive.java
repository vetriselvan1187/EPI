package Honor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vetriselvan on 26-12-2017.
 * Find first missing positive number
 */
public class FindFirstMissingPositive {
    public static void main(String[] args) {
        List<Integer> arrayOfIntegers = new ArrayList<Integer>();
        arrayOfIntegers.add(3);
        arrayOfIntegers.add(4);
        arrayOfIntegers.add(0);
        arrayOfIntegers.add(1);
        FindFirstMissingPositive findFirstMissingPositive = new FindFirstMissingPositive();
        System.out.println(findFirstMissingPositive.findFirstMissingPositive(arrayOfIntegers));
    }

    private Integer findFirstMissingPositive(List<Integer> arrayOfIntegers) {
        int i = 0;
        while (i < arrayOfIntegers.size()) {
            if (arrayOfIntegers.get(i) > 0 && arrayOfIntegers.get(i) <= arrayOfIntegers.size()
                    && arrayOfIntegers.get(arrayOfIntegers.get(i) - 1) != arrayOfIntegers.get(i)) {
                Collections.swap(arrayOfIntegers, i, arrayOfIntegers.get(i) - 1);
            } else {
                ++i;
            }
        }
        for (int j = 0; j < arrayOfIntegers.size(); j++) {
            if (arrayOfIntegers.get(j) != j + 1) {
                return j + 1;
            }
        }
        return arrayOfIntegers.size() + 1;
    }
}

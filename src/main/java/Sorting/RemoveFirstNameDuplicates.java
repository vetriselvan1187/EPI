package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vetriselvan on 05-01-2018.
 * 14.3 Remove First Name Duplicates
 * Time Complexity O(nlogn) and Space Complexity O(1)
 */
public class RemoveFirstNameDuplicates {
    static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int compareTo(Name name) {
            int cmpFirst = firstName.compareTo(name.firstName);
            if(cmpFirst != 0)
                return cmpFirst;
            return lastName.compareTo(name.lastName);
        }
    }

    public static void main(String[] args) {
        List<Name> listOfNames = Arrays.asList(new Name("Ian", "Botham"), new Name("David", "Gower"),
                new Name("Ian", "Bell"), new Name("Ian", "Chappel"), new Name("Edwin", "Calcikan"));
        RemoveFirstNameDuplicates  removeFirstNameDuplicates = new RemoveFirstNameDuplicates();
        List<Name> dedupedList = removeFirstNameDuplicates.eliminateDuplicates(listOfNames);
        for(Name name : dedupedList) {
            System.out.println(name.firstName +" "+name.lastName);
        }
    }

    private List<Name> eliminateDuplicates(List<Name> names) {
        Collections.sort(names);
        int result = 0;
        for(int first = 1; first < names.size(); first++) {
            if(!names.get(first).firstName.equals(names.get(result).firstName)) {
                names.set(++result, names.get(first));
            }
        }
        return names.subList(0, ++result);
    }
}

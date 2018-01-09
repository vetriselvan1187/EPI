package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vetriselvan on 07-01-2018.
 * 16.6 Generate Balanced parantheses
 *
 */
public class GenerateBalancedParantheses {
    public static void main(String[] args) {
        GenerateBalancedParantheses generateBalancedParantheses = new GenerateBalancedParantheses();
        List<String> balancedParensList = generateBalancedParantheses.generateBalancedParantheses(2);
        for(String str : balancedParensList) {
            System.out.println(str);
        }
    }

    private List<String> generateBalancedParantheses(int numPairs) {
        List<String> result = new ArrayList<String>();
        directedGenerateBalancedParantheses(numPairs, numPairs, "", result);
        return result;
    }

    private void directedGenerateBalancedParantheses(int numLeftPairs, int numRightPairs, String validPrefix,
                                                     List<String> result) {
        System.out.println(validPrefix+" "+numLeftPairs+" "+numRightPairs);
        if(numLeftPairs == 0 && numRightPairs == 0) {
            result.add(validPrefix);
            return;
        }
        if(numLeftPairs > 0) {
            directedGenerateBalancedParantheses(numLeftPairs-1, numRightPairs, validPrefix+"(", result );
        } else if(numLeftPairs < numRightPairs) {
            directedGenerateBalancedParantheses(numLeftPairs, numRightPairs-1, validPrefix+")", result);
        }
    }
}

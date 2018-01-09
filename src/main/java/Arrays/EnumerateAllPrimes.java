package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vetriselvan on 28-12-2017.
 * 6.8 Enumerate all primes to n
 */

public class EnumerateAllPrimes {
    public static void main(String[] args){
        int n = 20;
        EnumerateAllPrimes enumerateAllPrimes = new EnumerateAllPrimes();
        List<Integer> primes = enumerateAllPrimes.generateAllPrimes(n);
        for(Integer a : primes) {
            System.out.print(a);
            System.out.print(' ');
        }
    }

    private List<Integer> generateAllPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(n+1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for(int p = 2; p <= n; p++) {
            if(isPrime.get(p)) {
                primes.add(p);
                for(int j=p; j <= n; j+=p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }
}

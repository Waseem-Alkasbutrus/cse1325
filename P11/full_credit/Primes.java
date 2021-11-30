import java.util.ArrayList;
import java.text.NumberFormat;

// main method by Professor George F. Rice

public class Primes {
    private int numThreads;
    private ArrayList<Integer> primes;

    public Primes(int numThreads) {
        this.numThreads = numThreads;
        this.primes = new ArrayList<>(0);
    }

    public Primes findPrimes(int lower, int upper) {
        for (int i = lower; i <= upper; i++) {
            if (isPrime(i)) {
                this.primes.add(i);
            }
        }
        return this;    
    }

    protected boolean isPrime(int number) {
        boolean isPrime = true;
        int sqrt = (int) Math.sqrt(number);

        for(int i = 2; i <= sqrt; i++) {
            if (number%i == 0) isPrime = false;
        }

        return isPrime;
    }

    public int numberOfPrimes() {
        return this.primes.size();
    }

    public Object[] toArray() {
        return this.primes.toArray();
    }
    
    public static void main(String[] args) {
        int numThreads = 1;
        int lower = 0;
        int upper = 3000000; // defaults
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }
        
        Primes primes = new Primes(numThreads); // Search using one thread
        int sumOfPrimes = 0;
        for(Object o : primes.findPrimes(lower, upper).toArray())
            if (o instanceof Integer) {
                Integer prime = (Integer) o;
                sumOfPrimes += prime;
                System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between " 
                             + lower + " and " 
                             + upper + " is " 
                             + NumberFormat.getIntegerInstance().format(sumOfPrimes));

            }
    }
}

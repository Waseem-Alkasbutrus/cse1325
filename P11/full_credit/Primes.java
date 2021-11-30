import java.util.ArrayList;
import java.text.NumberFormat;

// main method by Professor George F. Rice

public class Primes implements Runnable {
    private final static Object lock = new Object();
    private int numThreads;
    private final static ArrayList<Integer> primes = new ArrayList<>(0);;
    private int threadLower;
    private int threadUpper;

    public Primes(int numThreads) {
        this.numThreads = numThreads;
    }

    public Primes(int threadLower, int threadUpper) {
        this.threadLower = threadLower;
        this.threadUpper = threadUpper;
    }

    public Primes findPrimes(int lower, int upper) throws InterruptedException {
        //break total upper and lower into sections based on numThreads
        //create and start threads
        Thread[] threads = new Thread[numThreads];
        int sectionSize = upper/numThreads;
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Primes(upper - (sectionSize * (i + 1)), upper - (sectionSize * (i + 0))));
            threads[i].start();
        }
        //join threads
        for (Thread t : threads) {
            t.join();
        }

        return this;
    }

    @Override
    public void run() {
        addPrimes(threadLower, threadUpper);
    }

    protected void addPrimes(int lower, int upper) {
        for (int i = lower; i <= upper; i++) {
            if (isPrime(i)) {
                synchronized (lock) {
                    primes.add(i);
                }
            }
        }
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
        return primes.size();
    }

    public Object[] toArray() {
        return primes.toArray();
    }
    
    public static void main(String[] args) throws InterruptedException {
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

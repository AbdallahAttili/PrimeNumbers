import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int counter = 0;

        System.out.println("prime numbers list from 1 to 100 :  ");
        for (int i = 0; i < 100; i++) {
            System.out.print("  " + i + ": " + isPrime1(i) + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }


        System.out.println("\n==================================================================");


        System.out.println("prime numbers list from 100 to 200");
        for (int i = 100; i <= 200; i++) {
            System.out.print(" " + i + " : " + isPrime2(i) + " ");
            if (i % 5 == 0 && i != 100) {
                System.out.println();
            }
        }

        System.out.println("\n======================================================================");


        for (int i = 300; i <= 400; i++) {
            if (isPrime3(i)) {
                counter++;
            }
        }

        System.out.println("There are " + counter + " prime number/s in the range from 300 to 400 ");

        System.out.println("There are : " + sieveAlgorithm(100) + " prime numbers in the range.");

        System.out.println("There are : " + sieveAlgorithm(200) + " prime numbers in the range.");

        System.out.println(Math.log10(100));


        System.out.println(isPrimeTest(97));


        System.out.println(isPrime4(10));
        System.out.println(isPrime4(11));
    }

    public static boolean isPrimeTest(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrime1(int n) {
        // find if the number is prime or not in o(n) time complexity.
        if (n == 2) return true;
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrime2(int n) {
        // find if the number is prime or not in o(n) time complexity. (much better than the first one) .
        if (n == 2) return true;

        if (n < 2 || n % 2 == 0) return false;


        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    static boolean isPrime3(int n) {
        if (n == 2) return true;

        if (n < 2 || n % 2 == 0) return false;

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }

    static boolean isPrime4(int n) {
        // o(sqrt(n)) time complexity
        if (n == 2) return true;

        if (n < 2 || n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int sieveAlgorithm(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int counter = 0;

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (boolean b : isPrime) {
            if (b) counter++;
        }


        return counter;
    }

}

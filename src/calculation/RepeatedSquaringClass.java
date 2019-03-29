package calculation;

public class RepeatedSquaringClass {

    public static void main(String[] args) {
        new RepeatedSquaringClass().example();
    }

    private void example() {
        System.out.printf("2^10 [expect 1024] >>> %d\n", RepeatedSquaring.powMod(2, 10, 1_000_000_007));
        System.out.printf("123456789^6574837563712 mod 234567894 [expect 120678297] >>> %d\n"
                , RepeatedSquaring.powMod(123_456_789, 6_574_837_563_712L, 234_567_894));
    }

    static class RepeatedSquaring {
        static long powMod(long n, long p, long mod) {
            if (p == 0) {
                return 1;
            } else if (p % 2 == 1) {
                return powMod(n, p - 1, mod) * n % mod;
            } else {
                long s = powMod(n, p / 2, mod);
                return s * s % mod;
            }
        }
    }
}

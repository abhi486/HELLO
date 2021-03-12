import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void solve() throws IOException {
        long n = sc.nextLong();
        Set<Long> set = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            long x = (long) i*i;
            while (x <= n){
                set.add(x);
                x *= i;
            }
        }
        System.out.println(n - set.size());
    }
    public static void main(String[] args) throws IOException {
        int t;
//        t = sc.nextInt();
        t = 1;
        while (t-- > 0){
            solve();
        }
        System.gc();
    }
}

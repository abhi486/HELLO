import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Codeforces {

    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void solve(int T) throws IOException {
        int n = 10;
        while (n <= 101) {
            n += 10;
        }
        System.out.println(n);
        System.out.println(n+1);
    }

    public static void main(String[] args) throws IOException {
        int t;
//        t = sc.nextInt();
        t = 1;
        while (t-- > 0){
            solve(t);
        }
        System.gc();
    }
}



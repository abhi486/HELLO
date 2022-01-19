import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        GoogleKickStart googleKickStart = new GoogleKickStart();
        googleKickStart.solveQues();
    }
}

class GoogleKickStart {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final FastScanner fs = new FastScanner();
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int iInf = (int)(1e8);
    private static final long lInf = (long)(1e17);

    /** Optimal(Maximum,Minimum) Answers
     * 1. Binary search
     * 2. Prefix Suffix
     * 3. Greedy (sorting searching)
     * 4. DP
     **/
    void solve(int T) throws IOException {

    }
    void solveQues() throws IOException{
        int t = 1;
        t = fs.nextInt();
//        t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            solve(tt);
        }
        System.gc();
    }
}

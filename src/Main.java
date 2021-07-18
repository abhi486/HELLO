import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        SolveQue solveQue = new SolveQue();
        solveQue.ques();
    }
}

class SolveQue {
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
    private static int[] phi;
    /** Optimal(Maximum,Minimum) Answers
     * 1. Binary search
     * 2. Prefix Suffix
     * 3. Greedy (sorting searching)
     * 4. DP
     **/
    public static class Pair<T1 extends Comparable<T1>,T2 extends Comparable<T2>> implements Comparable<Pair<T1,T2>> {
        T1 first;
        T2 second;

        Pair() {}
        Pair(T1 a, T2 b) {
            this.first = a;
            this.second = b;
        }

        @Override
        public String toString() {
            return "[" + first + ", " + second + "]";
        }

        public int hashCode() {
            return this.first.hashCode() * 13 + (this.second == null ? 0 : this.second.hashCode());
        }

        public boolean equals(Object var1) {
            if (this == var1) {
                return true;
            } else if (!(var1 instanceof Pair)) {
                return false;
            } else {
                Pair var2 = (Pair) var1;
                if (this.first != null) {
                    if (!this.first.equals(var2.first)) {
                        return false;
                    }
                } else if (var2.first != null) {
                    return false;
                }

                if (this.second != null) {
                    if (!this.second.equals(var2.second)) {
                        return false;
                    }
                } else if (var2.second != null) {
                    return false;
                }

                return true;
            }
        }

        @Override
        public int compareTo(Pair<T1, T2> o) {
            if (this.first.equals(o.first)) {
                return this.second.compareTo(o.second);
            }
            return this.first.compareTo(o.first);
        }
    }
    static long fastExpo(long a,long n,long mod){
        if (n == 0)
            return 1;
        else{
            long x = fastExpo(a,n/2,mod);
            if ((n&1) == 1){
                return (((a*x)%mod)*x)%mod;
            }
            else{
                return (((x%mod)*(x%mod))%mod)%mod;
            }
        }
    }
    public static void nextPermutation(int[] a) {
        int index1 = -1;
        for (int i=a.length-1;i>0;i--){
            if (a[i] > a[i-1]){
                index1 = i-1;
                break;
            }
        }
        if (index1 == -1){
            int i = index1+1;
            int j = a.length - 1;
            while (i < j){
                swap(a,i,j);
                i++;
                j--;
            }
            return;
        }
        int index2 = 0;
        for (int i=a.length-1;i>index1;i--){
            if (a[index1] < a[i]){
                index2 = i;
                break;
            }
        }
        swap(a,index1,index2);
        int i = index1 + 1;
        int j = a.length - 1;
        while (i < j){
            swap(a,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static class FenwickTree {
         int maxN;
         int[] BIT;
         FenwickTree() {
             maxN = 0;
         }
         FenwickTree(int maxN) {
             this.maxN = maxN;
             BIT = new int[maxN];
         }
         void add(int x,int v){
             while(x < maxN) {
                 BIT[x] += v;
                 x += (x & -x);
             }
         }
         int sum(int x){
             return x > 0 ? BIT[x] + sum(x - ((x & -x))) : 0;
         }
    }
    class SegmentTree {
        private long[] st;
        private int size;
        private int n;
        private long[] a;
        SegmentTree(long[] a,int n){
            this.size = 4*n;
            this.n = n;
            this.a = a;
            st = new long[size];
            //Arrays.fill(st,Integer.MIN_VALUE);
            buildSegmentTree(0,0,n-1);
            //printSegmentTree();
        }
        public long buildSegmentTree(int index,int l,int r){
            if (l == r){
                st[index] = a[l];
                return a[l];
            }
            int mid = (r+l) >> 1;
            return st[index] = buildSegmentTree(2*index+1,l,mid) + buildSegmentTree(2*index+2,mid+1,r);
        }
        public void printSegmentTree(){
            for (long x : st){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        public long query(int ql,int qr){
            return getQuery(0,0,n-1,ql-1,qr-1);
        }

        private long getQuery(int index,int sl,int sr,int ql,int qr){
            //System.out.println("#" + index);
            if (qr < sl || ql > sr)
                return 0;
            if (ql <= sl && qr >= sr)
                return st[index];
            int mid = (sr + sl) >> 1;
            return getQuery(2*index+1,sl,mid,ql,qr) + getQuery(2*index+2,mid+1,sr,ql,qr);
        }
        public void update(int i,long newVal){
            //long diff = newVal - a[i];
            a[i] = newVal;
            updateSegmentTree(0,i,0,n-1,newVal);
        }
        private void updateSegmentTree(int index,int i,int sl,int sr,long diff){
            if (sl == sr){
                st[index] = diff;
                return;
            }
            int mid = (sl + sr) >> 1;
            if (i <= mid)
                updateSegmentTree(2*index+1,i,sl,mid,diff);
            else
                updateSegmentTree(2*index+2,i,mid+1,sr,diff);
            st[index] = st[2*index+1] + st[2*index+2];
        }
    }
    static void eulerTotient(int n) {
        phi = new int[n + 1];
        for (int i = 1;i <= n; i++) {
            phi[i] = i;
        }
        for (int i = 2;i <= n; i++) {
            if (phi[i] == i) {
                phi[i] = i - 1;
                for (int j = 2*i; j <= n; j += i) {
                    phi[j] = (phi[j] * (i - 1))/i;
                }
            }
        }
    }
    public static int[] LPS(String p){
        int[] lps = new int[p.length()];
        int i=1;
        int j=0;
        while (i < p.length()){
            if (p.charAt(i) == p.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if (j == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }

    public static void KMP(String text,String pattern){
        int[] lps = LPS(pattern);
        int i = 0;
        int j = 0;
        ArrayList<Integer> matches = new ArrayList<>();
        while (i < text.length()){
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                matches.add(i - j);
                j = lps[j-1];
            }
        }
        for (int x : matches){
            System.out.println("Match at : " + x);
        }
    }
    static int highestPowerOf2(int n) {
        int p = (int)(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, p);
    }
    public static int log2(long val){
        return (int) Math.floor(Math.log(val)/Math.log(2));
    }
    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (long i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
            return true;
    }
    void solve(int T) throws IOException {

    }
    void ques() throws IOException {
        int t = 1;
        t = sc.nextInt();
//        t = fs.nextInt();
//        t = Integer.parseInt(br.readLine());
        int tt = 1;
        while (t-- > 0) {
            solve(tt);
            tt++;
        }
        System.gc();
    }
}
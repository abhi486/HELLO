import java.io.*;
import java.util.Scanner;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void solve() throws IOException {
        File openFile = new File("input.txt");
        FileWriter writeFile = new FileWriter("output.txt");
        Scanner scanner = new Scanner(openFile);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            int ans = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
            writeFile.append(String.valueOf(ans));
            writeFile.append("\n");
        }
        writeFile.close();
        openFile = new File("output.txt");
        scanner = new Scanner(openFile);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws IOException{
        int t;
        //t = sc.nextInt();
        t = 1;
        while (t-- > 0){
            solve();
        }
        System.gc();
    }
}





/*
	Grammar:
	E -> x + T
	T -> (E)
	T -> x
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

class RecursiveDescentParser {
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);
    static int ptr;
    static char[] input;

    public static void main(String[] args) {
        int t = 5;
        while (t-- > 0) {
            //System.out.println("Enter the input string:");
            String s = sc.nextLine();
            input = s.toCharArray();
            if (input.length < 2) {
                System.out.println("The input string is invalid.");
                System.exit(0);
            }
            ptr = 0;
            boolean isValid = E();
            if ((isValid) & (ptr == input.length)) {
                System.out.println("The input string is accepted.");
            } else {
                System.out.println("The input string is not accepted.");
            }
        }
    }

    static boolean E() {
        // Check if 'ptr' to 'ptr+2' is 'x + T'
        //System.out.println("E: " + input[ptr]);
        int fallback = ptr;
        if(input[ptr++] != 'x') {
            ptr = fallback;
            return false;
        }
        if(input[ptr++] != '+') {
            ptr = fallback;
            return false;
        }
        if(!T()) {
            ptr = fallback;
            return false;
        }
        return true;
    }

    static boolean T() {
        // Check if 'ptr' to 'ptr+2' is '(E)' or if 'ptr' is 'x'
        int fallback = ptr;
        //System.out.println("T : " + input[ptr]);
        if(input[ptr] == 'x') {
            ptr++;
        }
        else {
            if(input[ptr++] != '(') {
                ptr = fallback;
                return false;
            }
            if(!E()) {
                ptr = fallback;
                return false;
            }
            if(input[ptr++] != ')') {
                ptr = fallback;
                return false;
            }
        }
        return true;
    }
}

/*
	Sample Inputs:
xxx
x+x+x
x+(x+x)
x+(x+(x+x))
x+(x+x)+x
*/
import java.util.*;
public class Hackerearth {
    public static boolean palindrome(String s)
    {
        Stack stack = new Stack();
        int i=0;
        while (i<s.length())
            stack.push(s.charAt(i++));
        i = 0;
        boolean check = false;
        while (i<s.length()) {
            if ((char) stack.peek() == s.charAt(i++))
                check = true;
            else {
                check = false;
                break;
            }
        }
        return check;
        }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String string = sc.next();
        int depth=0;
        if (palindrome(string))
        {
            if (string.length()%2==0)
                depth=string.length()/2;
        }
        int laststring=0;
        while (depth%2==0)
            laststring = depth/2;
        System.out.println(depth + "\n");
        char[] astr = string.toCharArray();
        for (int i=0;i<=laststring;i++)
            System.out.print(astr[i]);
    }
}

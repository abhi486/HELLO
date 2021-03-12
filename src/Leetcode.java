import java.util.Scanner;

public class Leetcode {
    public static String reverse(String s){
        String rev = "";
        for (int i=s.length()-1;i>=0;i--)
            rev+=String.valueOf(s.charAt(i));

        return rev;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String fans = "";
        int counter = s.length();
       for (int i=s.length()-1;i>=0;i--)
       {
           if (i==0 || s.charAt(i)==' ') {
               fans += s.substring(i, counter).trim() + " ";
               counter = i;
           }
       }
        System.out.println(fans.substring(0,s.length()));
    }
}

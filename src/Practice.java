import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice {
    static void reverse(ArrayList<Integer> list,int i,int j) {
        while (i <= j) {
            swap(list,i,j);
            i++; j--;
        }
    }
    static void swap(ArrayList<Integer> list,int i,int j) {
        int t = list.get(i); // t = arr[i];
        list.set(i,list.get(j)); //arr[i] = arr[j];
        list.set(j,t); // arr[j] = t;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = new Integer[5];
        Arrays.sort(arr,new Comparator<Integer>() {
            public int compare(Integer o1,Integer o2) {
                return o1 - o2;
            }
        });
    }
}
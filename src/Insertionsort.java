import java.util.*;
public class Insertionsort {
    public static void Insertsort(int[] a,int n)
    {
        int temp,j;
        for (int i=1;i<n;i++) {
            j = i - 1;
            temp = a[i];
            while (j >= 0 && a[j] > temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
    }
    public static void main(String[] args){
        int[] a = {5,3,1,2,4};
        System.out.println("Before Insertion sort");
        for (int i:a) {
            System.out.print(i + " ");
        }
        int n=a.length;
        Insertsort(a,n-1);
        System.out.println("\nAfter Insertion sort");
        for (int i=0;i<n;i++)
            System.out.print(a[i] + " ");
    }
}

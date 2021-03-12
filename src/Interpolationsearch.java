import java.util.*;
public class Interpolationsearch {
    public static int Interpolation(int[] a,int n,int x)
    {
        int lo=0;
        int hi=n-1;
        while(lo<=hi && x>=a[lo] && x<=a[hi]) {
            if (lo == hi) {
                return lo;
            }
            int pos;
            pos = lo + ((hi - lo) / (a[hi] - a[lo])) * (x - a[lo]);
            if (a[pos] == x)
                return pos;
            else if (a[pos] <= x)
                lo = pos + 1;
            else
                hi = pos - 1;
        }
        return -1;
    }
    public static void main(String[] arsgs){
        int arr[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
                24, 33, 35, 42, 47};
        int n=arr.length;
        int x = 18; // Element to be searched
        int index = Interpolation(arr,n,x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found.");
    }
}

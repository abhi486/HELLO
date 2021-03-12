import java.util.*;
public class MergeSort {
    public static void Merge(int[] a,int l,int m,int r)
    {
        int n1,n2;
        n1=m-l+1;
        n2=r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i=0;i<n1;i++)
            L[i]=a[l+i];
        for (int j=0;j<n2;j++)
            R[j] = a[m+1+j];
        int i,j,k;
        i=0;j=0;k=l;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
                a[k++]=L[i++];
            else
                a[k++]=R[j++];
        }
        while(i<n1)
            a[k++]=L[i++];
        while(j<n2)
            a[k++]=R[j++];

    }
    public static void Mergesort(int[] a,int l,int r)
    {
        if(l<r) {
            int mid = (l + r) / 2;
            Mergesort(a, l, mid);
            Mergesort(a, mid + 1, r);
            Merge(a, l, mid, r);
        }
        else
            return;
    }
    public static void main(String[] args)
    {
        int[] a = {5,3,1,2,4};
        int n=a.length;
        Mergesort(a,0,n-1);
        for (int i=0;i<n;i++)
            System.out.print(a[i] + " ");
    }
}

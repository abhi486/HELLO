public class Heapsort {
    public static void heapify(int[] a,int n,int i)
    {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && a[l]>a[largest])
            largest=l;
        else if(r<n && a[r]>a[largest])
            largest=r;
        if(largest!=i)
        {
            int temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            heapify(a,n,largest);
        }

    }
    public static void heapsort(int[] a,int n)
    {
        for(int i=0;i<n/2-1;i++)
            heapify(a,n,i);
        
        for (int i=n-1;i>=0;i--)
        {
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify(a,i,0);
        }
    }
    public static void main(String[] args){
        int[] a = {5,3,1,2,4};
        System.out.println("Before heap sort");
        for (int i:a) {
            System.out.print(i + " ");
        }
        int n=a.length;
        heapsort(a,n-1);
        System.out.println("\nAfter heap sort");
        for (int i=0;i<n;i++)
            System.out.print(a[i] + " ");

    }
}

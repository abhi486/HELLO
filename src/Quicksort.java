public class Quicksort {
    public static int partion(int[] a,int l,int h)
    {
        int pivot=a[h];
        //System.out.println(pivot);
        int i=l-1;
        for (int j=l;j<h;j++)
        {
            if(a[j]<pivot)
            {
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[h];
        a[h]=temp;
        for (int x:a) {
            System.out.print(x + " ");
        }
        System.out.println();
        return i+1;
    }
    public static void quicksort(int[] a,int l,int h)
    {
        if(l<h)
        {
            int pi = partion(a,l,h);
            quicksort(a,l,pi-1);
            quicksort(a,pi+1,h);
        }
    }
    public static void main(String[] args){
        int[] a = {5,3,1,2,4};
        System.out.println("Before quick sort");
        for (int i:a) {
            System.out.print(i + " ");
        }
        System.out.println();
        int n=a.length;
        quicksort(a,0,n-1);
        System.out.println("After quick sort");
        for (int i=0;i<n;i++)
            System.out.print(a[i] + " ");

    }
}

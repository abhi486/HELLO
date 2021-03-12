import java.util.*;

public class codechef {

public static int binsearch(int arr[], int l, int r, int x)
{
    if (r >= l) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] > x)
            return binsearch(arr, l, mid - 1, x);
        return binsearch(arr, mid + 1, r, x);
    }
    return -1;
}
    public static int MIN(int a,int b,int c)
    {
        if (a<b && a<c)
            return a;
        else if (b<a && b<c)
            return b;
        else
            return c;
    }
    public static boolean Prime(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static long GCD (long a,long b){
      if (a==0)
          return b;
      return GCD(b%a,a);
    }
    public static void SOE(long m,long n){
         long[] list = new long[(int)(n-m)];
         list[0] = 1;
         list[1]=1;
         for (long i=m;i<=Math.sqrt(list.length);i++)
         {
             if (list[Math.toIntExact(i)]==0){
                 for (long j=2*i;j<=list.length;j+=i)
                    list[Math.toIntExact(j)]=1;
             }
         }
         for (int i=0;i<list.length;i++)
         {
             if (list[i]==0)
                 System.out.println(i);
         }
    }
    public static long rev(long n){
       long x = n;
       long rev = 0;
       while (n!=0){
           rev = rev*10 + n%10;
           n/=10;
       }
       return rev;
    }
    public static float maxVol(float P, float A)
    {
        // calculate length
        float l = (float)(P - Math.sqrt(P * P - 24 * A)) / 12;

        // calculate volume
        float V = (float)(l * (A / 2.0 - l * (P / 4.0 - l)));

        // return result
        return V;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }
    public static void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start) {
        list.add(new ArrayList<>(resultList));
        for (int i = start; i < nums.length; i++) {
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> mp = new HashMap<>();
        Iterator<Character> it = mp.keySet().iterator();
        Stack stack = new Stack();

        ArrayList<ArrayList<Integer>> timeInterval = new ArrayList<>();
        int n = sc.nextInt();
        int z = 0;
        while (n!=0){
            ArrayList<Integer> list = new ArrayList<>();
            z++;
            System.out.println("Enter the event " + z);
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x);
                list.add(y);
            timeInterval.add(list);
            --n;
        }
        Collections.sort(timeInterval, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (ArrayList<Integer> list: timeInterval
             ) {
            System.out.println(list);
        }
        int PreviousStartTime = timeInterval.get(0).get(0);
        int PreviousEndTime = timeInterval.get(0).get(1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i=1;i<timeInterval.size();i++){
            if (timeInterval.get(i).get(0) <= PreviousEndTime){
                PreviousEndTime = timeInterval.get(i).get(1);
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(PreviousStartTime);
                list.add(PreviousEndTime);
                result.add(list);

                PreviousStartTime = timeInterval.get(i).get(0);
                PreviousEndTime = timeInterval.get(i).get(1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(PreviousStartTime);
        list.add(PreviousEndTime);
        result.add(list);
        for (ArrayList<Integer> lists : result)
            System.out.println(lists);
}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Practice {

    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void permute(String s, String str, List<String> ans){
        if (s.length()==0){
            ans.add(str);
            return;
        }
        boolean[] chars = new boolean[26];
        for (int i=0;i<s.length();i++){
            String x = s.substring(0,i) + s.substring(i+1);
            if (!chars[s.charAt(i) - 'a'])
                permute(x,str + s.charAt(i),ans);
            chars[s.charAt(i) - 'a'] = true;
        }
    }

    public static class Pair<K,V>{
        K a;
        V b;
        Pair(K a,V b){
            this.a = a;
            this.b = b;
        }
    }

    public static int findSS(int[] a,int n){
       Map<Integer,Integer> mp = new HashMap<>();
       int ans = 0;
       int currsum = 0;
       for (int i=0;i<n;i++){
           currsum += a[i];
           if (currsum==0){
               ans++;
           }
           if (mp.containsKey(currsum)){
               ans += mp.get(currsum);
           }
           mp.merge(currsum, 1, Integer::sum);
       }
       return ans;
    }


    public static void merge(int[] a,int l,int r,int mid){
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = l;i <= mid;i++){
            left.add(a[i]);
        }
        for (int i = mid + 1;i<=r;i++){
            right.add(a[i]);
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < left.size() && j < right.size()){
            if (left.get(i) < right.get(j))
                a[k++] = left.get(i++);
            else
                a[k++] = right.get(j++);
        }
        while (i < left.size()){
            a[k++] = left.get(i++);
        }
        while(j < right.size()){
            a[k++] = right.get(j++);
        }
    }
    public static void mergeSort(int[] a,int l,int r){
        if (l < r){
            int mid = l + (r - l)/2;

            mergeSort(a,l,mid);
            mergeSort(a,mid + 1,r);
            merge(a,l,r,mid);
        }
    }

    public static int partition(int[] a,int l,int r,int pivot){
        int s = l;
        int e = r;
        while (s < e){
            while (s < r && a[s] <= pivot)
                s++;
            while (e > l && a[e] >= pivot)
                e--;
            if (s < e){
                int temp = a[s];
                a[s] = a[e];
                a[e] = temp;
            }
        }
        return e;
    }
    public static void quickSort(int[] a,int l,int r){
        if (l < r){
            int pivot = a[l];
            int partition_index = partition(a,l,r,pivot);
            int temp = a[partition_index];
            a[partition_index] = a[l];
            a[l] = temp;
            quickSort(a,l,partition_index - 1);
            quickSort(a,partition_index + 1,r);
        }
    }

    public static void subSets(int[] a,int n,ArrayList<Integer> subset){
        if (n == 0){
            System.out.println(subset);
            return;
        }
        subset.add(a[n-1]);
        subSets(a,n-1,subset);
        subset.remove(subset.size() - 1);
        subSets(a,n-1,subset);
    }

    public static void Merge3Way(int[] a,int l,int r){
        if (r - l > 2){
            int mid1 = l + (r - l)/3;
            int mid2 = l + 2*((r - l)/3) + 1;

            Merge3Way(a,l,mid1);
            Merge3Way(a,mid1,mid2);
            Merge3Way(a,mid2,r);

            merge(a,l,mid1,mid2,r);
        }
    }
    private static void merge(int[] a, int l, int mid1, int mid2, int r) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i=l;i<=mid1;i++){
            list1.add(a[i]);
        }
        for (int i=mid1+1;i<=mid2;i++){
            list2.add(a[i]);
        }
        for (int i=mid2+2;i<=r;i++){
            list3.add(a[i]);
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int s = l;
        while (i < list1.size() & j < list2.size() && k < list3.size()){
            if (list1.get(i) < list2.get(j) && list1.get(i) < list3.get(k)){
                a[s++] = list1.get(i++);
            }
            else if (list2.get(j) < list1.get(i) && list2.get(j) < list3.get(k)){
                a[s++] = list2.get(j++);
            }
            else {
                a[s++] = list3.get(k++);
            }
        }
        while (i < list1.size() && j < list2.size()){
            if (list1.get(i) < list2.get(j)){
                a[s++] = list1.get(i++);
            }
            else{
                a[s++] = list2.get(j++);
            }
        }
        while (j < list2.size() && k < list3.size()){
            if (list2.get(j) < list3.get(k)){
                a[s++] = list2.get(j++);
            }
            else{
                a[s++] = list3.get(k++);
            }
        }
        while (i < list1.size() && k < list3.size()){
            if (list1.get(i) < list3.get(k)){
                a[s++] = list1.get(i++);
            }
            else{
                a[s++] = list3.get(k++);
            }
        }
        while (i < list1.size()){
            a[s++] = list1.get(i++);
        }
        while (j < list2.size()){
            a[s++] = list2.get(j++);
        }
        while (k < list3.size()){
            a[s++] = list3.get(k++);
        }
    }

    static int maxSum = 0;
    public static void maxSumMod3(int[] a,int n,int sum){
        if (n == 0){
            if (sum%3 == 0) {
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }
        maxSumMod3(a,n-1,sum + a[n-1]);
        maxSumMod3(a,n-1,sum);
    }
    public static void solve(){
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        maxSumMod3(a,n,0);
        System.out.println(maxSum);
    }
    public static void main(String[] args) throws java.lang.Exception {

    }
}
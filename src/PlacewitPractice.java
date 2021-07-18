import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PlacewitPractice{


    public static int[] LPS(String p){
        int[] lps = new int[p.length()];

        int i=1;
        int j=0;
        while (i < p.length()){
            if (p.charAt(i) == p.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else{
                if (j == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }

    public static void KMP(String text,String pattern){
        int[] lps = LPS(pattern);
        int i = 0;
        int j = 0;
        ArrayList<Integer> matches = new ArrayList<>();
        while (i < text.length()){
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                matches.add(i - j);
                j = lps[j-1];
            }
        }
        for (int x : matches){
            System.out.println("Match at : " + x);
        }
    }
    public static int[] gcd(int a,int b){
        if (b == 0){
            return new int[]{a,1,0};
        }
        int[] g = gcd(b,a%b);
        int gcd = g[0];
        int x = g[2];
        int y = g[1] - (a/b)*g[2];
        return new int[]{gcd,x,y};
    }

    static int getMin(int[] dist,boolean[] vis){
        int vertex = -1;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<dist.length;i++){
            if (!vis[i] && dist[i] < min){
                min = dist[i];
                vertex = i;
            }
        }
        return vertex;
    }
    static void dijkstra(int[][] graph,int V){
        int[] dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] vis = new boolean[V+1];
        dist[0] = 0;
        int min_index = getMin(dist,vis);
        while (min_index != -1){
            vis[min_index] = true;
            for (int v = 0;v < graph[min_index].length;v++){
                if (graph[min_index][v] > 0 && dist[min_index] + graph[min_index][v] < dist[v]){
                    dist[v] = dist[min_index] + graph[min_index][v];
                }
            }
            min_index = getMin(dist,vis);
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(0 + "->" + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) throws IOException {
//        DSU dsu = new DSU(10);
//        dsu.setUnion(1,2);
//        dsu.setUnion(2,4);
//        dsu.setUnion(7,8);
//        System.out.println(dsu.isSame(1,4));
//        System.out.println(dsu.isSame(1,5));
//        dsu.printDSU();
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//        int[][] graph = new int[V][V];
//        for (int i = 0; i < E; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            int w = sc.nextInt();
//            graph[u][v] = w;
//            graph[v][u] = w;
//        }
        int[][] graph = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(graph, graph.length);
    }
}


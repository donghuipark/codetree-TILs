import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int sum, idx1, idx2;

    public Pair(int sum, int idx1, int idx2){
        this.sum = sum;
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public int compareTo(Pair p){
        if(this.sum != p.sum){
            return this.sum - p.sum;
        }
        else{
            if(this.idx1 != p.idx1){
                return this.idx1 - p.idx1;
            }
            else{
                return this.idx2 - p.idx2;
            }
        }
    }
}

public class Main{
    private static int n,m,k;
    private static int[] arr;
    private static int[] arr2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(new Pair(arr[i]+arr2[0], i, 0));
        }

        for(int i=0;i<k-1;i++){
            Pair best = pq.poll();
            int idx1 = best.idx1;
            int idx2 = best.idx2;

            idx2++;
            if(idx2 < m){
                pq.add(new Pair(arr[idx1] + arr2[idx2], idx1, idx2));
            }
        }
        System.out.println(pq.peek().sum);
    }
}
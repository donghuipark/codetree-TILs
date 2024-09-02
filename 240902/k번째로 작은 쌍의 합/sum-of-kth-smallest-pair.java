import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y ){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        return (this.x + this.y) - (p.x+p.y);
    }
}

public class Main {
    private static int n, m, k;
    private static int[] arr;
    private static int[] arr2;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        m = Integer.parseInt(st.nextToken());
        arr2 = new int[m];

        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(new Pair(arr[i], arr2[j]));
            }
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            Pair res = pq.poll();
            ans = res.x + res.y;
        }
    
        System.out.println(ans);
    }
}
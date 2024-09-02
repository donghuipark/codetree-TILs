import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x,  y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        return (this.x + this.y) - (p.y+p.x); 
    }
}
public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Pair(x, y));
        }

        for(int i=0;i<m;i++){
            Pair close = pq.poll();
            pq.add(new Pair(close.x+2, close.y+2));
        }

        Pair res = pq.peek();
        System.out.println(res.x + " " + res.y);
    }
}
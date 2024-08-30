import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pq.add(-Integer.parseInt(st.nextToken()));
        }        

        for(int i=0;i<m;i++){
            int max = -pq.poll();
            pq.add(-(max-1));
        }
        System.out.println(-pq.peek());
    }
}
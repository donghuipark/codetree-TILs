import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int cost = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            cost += a+b;
            pq.add(a+b);
        }    
        System.out.println(cost);
    }
}
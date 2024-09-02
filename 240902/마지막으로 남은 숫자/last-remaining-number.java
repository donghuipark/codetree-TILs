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
            pq.add(-Integer.parseInt(st.nextToken()));    
        }

        int max1 = 0;
        int max2 = 0;
        while(pq.size() > 1){
            max1 = pq.poll();
            max2 = pq.poll();

            if(max1 == max2){
                continue;
            }
            else{
                pq.add(Math.abs(max1-max2));
            }
        }

        if(pq.size() == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(pq.peek());
        }

    }
}
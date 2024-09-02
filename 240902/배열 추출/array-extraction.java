import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue <Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(-pq.poll());
                }
            }
            else{
                pq.add(-num);
            }
        }

    }
}
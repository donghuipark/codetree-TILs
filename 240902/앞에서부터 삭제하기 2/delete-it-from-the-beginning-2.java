import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        double max = Integer.MIN_VALUE;

        for(int k=1;k<n-1;k++){        
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=k;i<n;i++){
          //      System.out.println("arr[i] : " + arr[i]);
                pq.add(arr[i]);
            }
            pq.poll();
            int size = pq.size();
            int sum = 0;
            while(!pq.isEmpty()){
                sum += pq.poll();
            }
            max = Math.max(max, sum/size);
          //  System.out.println("k : " + k + " size = " + size + " max : " + max);
        }

        System.out.println(String.format("%.2f", max));
    }
}
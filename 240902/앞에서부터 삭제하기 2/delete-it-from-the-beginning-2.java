import java.io.*;
import java.util.*;

public class Main{

    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        double maxAvg = 0;

        pq.add(arr[n-1]);
        sum += arr[n-1];

        for(int i=n-2;i>=1;i--){
            pq.add(arr[i]);
            sum += arr[i];

            double avg = (double)(sum - pq.peek()) / (n-i-1);

            if(maxAvg < avg){
                maxAvg = avg;
            }
        }

        System.out.println("%.2f", maxAvg);
    }
}
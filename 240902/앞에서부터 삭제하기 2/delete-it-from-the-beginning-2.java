import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        double maxAverage = Double.NEGATIVE_INFINITY;

        // 모든 가능한 K에 대해 반복
        for (int k = 1; k <= n - 2; k++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int sum = 0;
            
            // K번째 이후의 요소들을 PriorityQueue에 추가하면서 합을 계산
            for (int i = k; i < n; i++) {
                pq.add(arr[i]);
                sum += arr[i];
            }
            
            // 가장 작은 값을 하나 제거
            sum -= pq.poll();

            // 남은 요소들의 수
            int remainingCount = n - k - 1;
            
            // 평균 계산
            double average = (double) sum / remainingCount;
            maxAverage = Math.max(maxAverage, average);
        }
        
        System.out.printf("%.2f", maxAverage);
    }
}
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
        
        // Prefix Sum을 계산
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        
        for (int k = 1; k <= n - 2; k++) {
            int minVal = Integer.MAX_VALUE;
            for (int i = k; i < n; i++) {
                minVal = Math.min(minVal, arr[i]);
            }
            
            int sum = prefixSum[n] - prefixSum[k] - minVal;
            int remainingCount = n - k - 1;
            
            double average = (double) sum / remainingCount;
            maxAverage = Math.max(maxAverage, average);
        }
        
        System.out.printf("%.2f", maxAverage);
    }
}
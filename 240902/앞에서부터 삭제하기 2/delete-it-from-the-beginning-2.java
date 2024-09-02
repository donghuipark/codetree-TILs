import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        double maxAverage = Double.NEGATIVE_INFINITY;
        
        // K를 1부터 N-2까지 탐색
        for (int K = 1; K <= N - 2; K++) {
            // K개의 원소를 삭제한 뒤 남은 배열을 가져옴
            int[] remaining = Arrays.copyOfRange(arr, K, N);
            Arrays.sort(remaining); // 정렬하여 가장 작은 값을 찾기 용이하게 함
            
            int sum = 0;
            for (int i = 1; i < remaining.length; i++) {
                sum += remaining[i];
            }
            
            double average = (double) sum / (remaining.length - 1);
            maxAverage = Math.max(maxAverage, average);
        }
        
        System.out.printf("%.2f", maxAverage);
    }
}
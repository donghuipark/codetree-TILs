import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        boolean allZeros = true;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] != 0) {
                allZeros = false; // 0이 아닌 숫자가 하나라도 있으면
            }
        }

        // 모든 숫자가 0일 때 특수 처리
        if (allZeros) {
            if (m == 0) {
                System.out.println((long)Math.pow(2, n));  // 2^n 출력
            } else {
                System.out.println(0);  // m != 0인 경우 0
            }
            return;
        }

        // dp 배열 선언: -20 <= sum <= 20, 총 41칸
        int[][] dp = new int[n][41];

        // 첫 번째 숫자에 대해 초기화
        dp[0][arr[0] + 20] = 1;  // 첫 번째 숫자를 더한 경우
        dp[0][-arr[0] + 20] += 1; // 첫 번째 숫자를 뺀 경우 (0일 때도 더하거나 빼는 경우 각각 추가)

        // 동적 계획법을 통해 가능한 경우의 수 계산
        for (int i = 1; i < n; i++) {
            for (int sum = -20; sum <= 20; sum++) {
                if (dp[i - 1][sum + 20] > 0) {  // 이전 값이 존재할 경우
                    // 더하는 경우
                    if (sum + arr[i] <= 20) {
                        dp[i][sum + arr[i] + 20] += dp[i - 1][sum + 20];
                    }
                    // 빼는 경우
                    if (sum - arr[i] >= -20) {
                        dp[i][sum - arr[i] + 20] += dp[i - 1][sum + 20];
                    }
                }
            }
        }

        // 마지막 숫자에서 목표 M에 도달하는 경우의 수 출력
        System.out.println(dp[n - 1][m + 20]);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // N 값
        m = Integer.parseInt(st.nextToken());  // 목표 M 값

        arr = new int[n];  // 숫자 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 크기: -20 <= sum <= 20을 표현하기 위해 41칸 사용 (인덱스를 +20 해서 사용)
        dp = new long[n][41];

        // 첫 번째 숫자에 대한 초기화
        dp[0][arr[0] + 20] = 1;  // 첫 번째 숫자를 더한 경우
        dp[0][-arr[0] + 20] += 1; // 첫 번째 숫자를 뺀 경우

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
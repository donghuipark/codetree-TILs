import java.io.*;
import java.util.*;

public class Main{
    private static int n, k;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 초기화
        dp = new int[n][k+1];
        for (int j = 0; j <= k; j++) {
            dp[0][j] = arr[0]; // 첫 번째 값으로 초기화
        }
        
        int ans = arr[0];  // 최대 합 초기화

        // DP 계산
        for (int i = 1; i < n; i++) {
            if (arr[i] >= 0) {
                // 양수일 때는 음수 개수에 변화가 없으므로 그대로 더해줌
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = dp[i-1][j] + arr[i];
                    ans = Math.max(ans, dp[i][j]);  // 최대값 갱신
                }
            } else {
                // 음수일 때는 음수 개수가 하나 증가해야 함
                dp[i][0] = Math.max(dp[i][0], arr[i]);  // 음수가 없을 때는 새로 시작할 수 있음
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + arr[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);  // 최대값 갱신
                }
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}
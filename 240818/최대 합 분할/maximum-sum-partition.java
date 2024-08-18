import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int halfSum = sum /2;
        dp = new int[n+1][halfSum+1];

        for(int i=1;i<=n;i++){
            for(int j=0;j<=halfSum;j++){
                // 이전 상태의 값 -> 현재숫자를 사용하지 않는 경우
                dp[i][j] = dp[i-1][j];

                if (j >= arr[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i]] + arr[i]);
                }
            }
        }
        // 최종 결과 찾기
        int ans = dp[n][halfSum];  // 마지막 행에서 최대의 값 찾기

        System.out.println(ans);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static boolean[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        // DP 테이블 초기화
        int halfSum = sum / 2;
        dp = new boolean[n+1][halfSum+1];
        dp[0][0] = true;  // 0개의 숫자로 합 0을 만드는 것은 항상 가능

        for(int i=1; i<=n; i++) {
            for(int j=halfSum; j>=0; j--) {
                if (j >= arr[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // 가능한 최대의 동일한 합 찾기
        int ans = 0;
        for (int j = halfSum; j >= 0; j--) {
            if (dp[n][j]) {
                ans = j;
                break;
            }
        }

        System.out.println(ans);
    }
}
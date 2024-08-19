import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] exp;
    private static int[] time;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        exp = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열의 크기는 경험치의 합 + 1
        dp = new int[m + 1];

        // dp 배열을 무한대로 초기화
        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;  // 0 경험치를 얻기 위한 시간은 0

        for (int i = 0; i < n; i++) {
            // 뒤에서부터 dp 배열을 갱신
            for (int j = m; j >= exp[i]; j--) {
                if (dp[j - exp[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
                }
            }
        }

        int result = dp[m];
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
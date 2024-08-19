import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 퀘스트 수
        int m = Integer.parseInt(st.nextToken());  // 목표 경험치

        int[] exp = new int[n];
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 초기화: 크기는 m+1 이상으로 설정하고 초기값을 최대값으로 설정
        int maxExp = 1000000;
        int[] dp = new int[maxExp + 1];
        for (int i = 1; i <= maxExp; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = maxExp; j >= exp[i]; j--) {
                if (dp[j - exp[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
                }
            }
        }

        // m 이상에서 최소 시간을 찾기
        int result = Integer.MAX_VALUE;
        for (int i = m; i <= maxExp; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
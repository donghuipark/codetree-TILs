import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int offset = 1000000;
    private static int n;
    private static int[] arr;
    private static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        
        dp = new int[n+1][2*offset+1];
        for(int i=0;i<=n;i++){
            for(int j=-sum;j<=sum;j++){
                dp[i][j+offset] = Integer.MIN_VALUE;
            }
        }
        dp[0][offset] = 0;

        for(int i=1;i<=n;i++){
            for(int j=-sum; j<=sum; j++){
                // a에 들어가는 경우 -> a-b가 증가.
                // 이전 상황은 j-arr[i]인 경우
                if (j-arr[i] >= -sum && j-arr[i] <= sum
                    && dp[i-1][j+offset-arr[i]] != Integer.MIN_VALUE) {
                
                        dp[i][j+offset] = Math.max(dp[i][j+offset], dp[i-1][j+offset-arr[i]] + arr[i]);
                }

                // b에 들어가는 경우 -> a-b 감소
                // 이전 상황은 j+arr[i]의 상황, 여기까지오면 이미 a-b감소상태
                if (j+arr[i] >= -sum && j+arr[i] <=sum
                    && dp[i-1][j+offset+arr[i]] != Integer.MIN_VALUE) {
                    
                        dp[i][j+offset] = Math.max(dp[i][j+offset] , dp[i-1][j+offset+arr[i]]);
                }

                // c에 들어가는 경우
                // 값은 변경되는게 아니고 이전의 j값이 그대로온다.
                if (dp[i-1][j+offset] != Integer.MIN_VALUE) {
                    dp[i][j+offset] = Math.max(dp[i][j+offset], dp[i-1][j+offset]);
                }
            }
        }

        System.out.println(dp[n][offset]);

    }
}
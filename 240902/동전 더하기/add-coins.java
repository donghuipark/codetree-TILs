import java.util.*;
import java.io.*;
public class Main {
    private static int n, k;
    private static int[] coins;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for(int i=n-1;i>=0;i--){
            while(k >= coins[i]){
                k -= coins[i];
                //System.out.println("coin : " + coins[i] + " k : " + k);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
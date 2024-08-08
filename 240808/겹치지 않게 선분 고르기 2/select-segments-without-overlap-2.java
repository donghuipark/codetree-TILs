import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int ans = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (o1, o2) -> (o1[1] == o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]));
        
        int end = arr[0][1];
        ans = 1;
        for(int i=1;i<n;i++){
            if (end < arr[i][0]) {
                end = arr[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] arr;

    private static boolean check(int d){
        int lastPoint = arr[0][0];

        for(int i=1;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(lastPoint + d > end){
                return false;
            }

            lastPoint = Math.max(start, lastPoint+d);
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else{
                return a[0] - b[0];
            }
        });


        int left = 0;
        int right = arr[n-1][1] - arr[0][0];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(check(mid)){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
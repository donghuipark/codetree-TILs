import java.util.*;
import java.io.*;

public class Main {
    private static int n,m;
    private static int[] arr;

    private static boolean distribute(int mid){
        int cnt = 0;

        for(int i=0;i<n;i++){
            int num = arr[i];
            while(num >= mid){
                cnt++;
                num -= mid;
            }
        }

        if(cnt >= m){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int right = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        int left = 1;
        int ans = 0;

        while(left <= right){
            int mid = (right + left) / 2;
            if(distribute(mid)){
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else{
                right = mid - 1;
            }
        }        

        System.out.println(ans);


    }
}
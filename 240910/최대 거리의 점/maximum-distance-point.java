import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int dist(int mid){
        int start = arr[0];
        int cnt = 1;

        for(int i=1;i<n;i++){
            if(Math.abs(arr[i] - start) >= mid){
                cnt++;
                start = arr[i];
            }
        }

        return cnt;
    }

    private static int binarySearch(int target){

        int left = 1;
        int right = arr[n-1] - arr[0];
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(dist(mid) >= target){
                ans = mid;
                left = mid + 1;        
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(m));
    }
}
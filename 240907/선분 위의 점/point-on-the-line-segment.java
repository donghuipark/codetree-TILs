import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int Lower(int target){
        int left = 0;
        int right = n-1;
        int minIdx = n;

        while(left <= right){
            int mid = (right+left) /2;

            if(arr[mid] >= target){
                // left target mid right
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                left = mid + 1;
            }
        }
        return minIdx;
    }

    private static int Upper(int target){
        int left = 0;
        int right = n-1;
        int maxIdx = -1;

        while(left <= right){
            int mid = (right+left) / 2;

            if(arr[mid] <= target){
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }
            else{
                right = mid - 1;
            }
        }
        return maxIdx;
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int minIdx = Lower(s);
            int maxIdx = Upper(e);
            int res = maxIdx - minIdx;
            if(res == -1){
                System.out.println(0);
            } 
            else{
                System.out.println(res+1);
            }
        }
    }
}
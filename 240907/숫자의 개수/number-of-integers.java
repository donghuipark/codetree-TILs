import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int Lower(int num){
        int left = 0;
        int right = n-1;
        int minIdx = n;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] >= num){
                // left num mid right
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                // left mid num right
                left = mid + 1;
            }
        }

        return minIdx;
    }

    private static int Upper(int num){
        int left = 0;
        int right = n-1;
        int maxIdx = -1;

        while(left <= right){
            int mid = (right+left) / 2;

            if(arr[mid] <= num){
                // left mid num right
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }
            else{   
                // left num mid right
                right = mid - 1;
            }
        }
        return maxIdx;
    }
    public static void main(String[] args) throws IOException {
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
            int num = Integer.parseInt(br.readLine());

            int minIdx = Lower(num);
            int maxIdx = Upper(num);

            if(minIdx == -1 || maxIdx == -1){
                System.out.println(0);
            }
            else{
                System.out.println(maxIdx - minIdx + 1);
            }
        }

    }
}
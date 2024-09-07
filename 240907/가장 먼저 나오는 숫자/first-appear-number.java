import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int Lower(int target){
        int left = 0;
        int right = n-1;
        int minIdx = n;

        if(target < arr[0] || target > arr[n-1]){
            return -1;
        }

        while(left <= right){
            int mid = (right + left) / 2;

            if(arr[mid] >= target){
                // left target mid right
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else{
                // left mid target right
                left = mid + 1;
            }
        }

        if(arr[minIdx] == target){
            return minIdx + 1;
        }
        else{
            return -1;
        }
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

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());

            int midIdx = Lower(num);

            System.out.println(midIdx);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static long n, m;
    private static long[] arr;

    private static long simulate(long time){
        long cnt = 0;

        for(long i=0;i<m;i++){
            cnt += time/arr[i];
        }

        return cnt;
    }
    private static long binarySearch(long target){
        long left = 1;
        long right = arr[m-1] * target;
        long ans = -1;

        while(left <= right){
            long mid = (right + left) / 2;

            if(simulate(mid) >= target){
                ans = mid;
                right = mid - 1;    
                          
            }
            else{
                left = mid + 1;
                
            }
        }

        return ans;
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new long[m];
        for(long i=0;i<m;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(n));

    }
}
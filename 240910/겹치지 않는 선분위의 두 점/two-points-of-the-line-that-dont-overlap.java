import java.util.*;
import java.io.*;


public class Main {
    private static int n, m;
    private static long[][] arr;

    private static long simulate(long distance){
        long cnt = 1;
        long lastPlaced = arr[0][0];

        for(int i=0;i<m;i++){
            long start = arr[i][0];
            long end = arr[i][1];

            while(lastPlaced + distance <= end){
                lastPlaced += distance;
                cnt++;
               

                if(cnt >= n){
                    return cnt;
                }
            }

            if(lastPlaced + distance <= start){
                lastPlaced = start;
            }
        }
        return cnt;
    }
    private static long binarySearch(int target){
        long left = 1;
        long right = arr[m-1][1] - arr[0][0];
        long ans = -1;
        while(left <= right){
            long mid = (right+left) / 2;

            if(simulate(mid) >= target){
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

        arr = new long[m][2];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (o1, o2) -> Long.compare(o1[0], o2[0]));
            

        System.out.println(binarySearch(n));

    }
}
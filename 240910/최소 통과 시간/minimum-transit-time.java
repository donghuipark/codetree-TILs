import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int simulate(int time){
        int cnt = 0;

        for(int i=0;i<m;i++){
            cnt += time/arr[i];
        }

        return cnt;
    }
    private static int binarySearch(int target){
        int left = 1;
        int right = arr[m-1] * target;
        int ans = -1;

        while(left <= right){
            int mid = (right + left) / 2;

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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(n));

    }
}
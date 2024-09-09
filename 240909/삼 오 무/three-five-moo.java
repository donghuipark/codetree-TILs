import java.util.*;
import java.io.*;

public class Main {
    private static int n;

    private static int moo(int num){
        return num - (num/5 + num/3 - num/15);
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = moo(mid);

            if(cnt >= n){
                // left ans mid right
                right = mid - 1;
                ans = mid;
            }
            else {
                // left mid ans right
                left = mid + 1;
            }
        
        }

        System.out.println(ans); 
    }
}
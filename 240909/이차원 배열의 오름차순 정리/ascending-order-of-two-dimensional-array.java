import java.util.*;
import java.io.*;

public class Main{
    private static long n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long l =1;
        long r = n*n;
        long ans = 1;
        while(l <= r){
            long mid = (l + r) / 2;

            long cnt = 0;
            for(long i=1;i<=n;i++){
                cnt += Math.min(n, mid/i);
            }

            if(cnt >= k){
                r = mid - 1; 
                ans = mid;
            }
            else{
                l = mid + 1;
            }
        }

        System.out.println(ans);
        
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static long n;

    private static boolean moo(long num){
        return num - ((num/5 + num/3 - num/15))  >= n;
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        long left = 1;
        long right = n*2;
        long ans = Integer.MAX_VALUE;
        while(left <= right){
            long mid = (left + right) / 2;

            if(moo(mid)){
                // left ans mid right
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                // left mid ans right
                left = mid + 1;
            }
        
        }

        System.out.println(ans); 
    }
}
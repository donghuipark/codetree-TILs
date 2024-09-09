import java.util.*;
import java.io.*;

public class Main {
    private static long s;


    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        s = Long.parseLong(br.readLine());

        long left = 1;
        long right = s;
        long maxIdx = -1;

        while(left<= right){
            long mid = (left + right) / 2;
            if(mid * (mid+1) /2 <= s){
                // left mid a  right
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            }
            else{
                // left  mid ans right
                right = mid - 1;
            }
        }

        System.out.println(maxIdx);    


    }
}
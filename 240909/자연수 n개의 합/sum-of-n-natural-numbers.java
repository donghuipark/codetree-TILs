import java.util.*;
import java.io.*;

public class Main {
    private static long s;


    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        s = sc.nextLong();

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
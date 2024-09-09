import java.util.*;
import java.io.*;

public class Main {
    private static int s;

    private static int binarySearch(int s){
        int left = 1;
        int right = s;
        int maxIdx = -1;

        while(left<= right){
            int mid = (left + right) / 2;
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
        return maxIdx;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        s = Integer.parseInt(br.readLine());

        int ans = binarySearch(s);

        System.out.println(ans);


    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static long s;

    private static long binarySearch(long s){
        long left = 1;
        long right = s;
        long maxIdx = -1;

        while(left <= right){
            long mid = (left + right) / 2;
            // 오버플로우를 방지하기 위한 조건
            if(mid > 0 && mid <= Long.MAX_VALUE / (mid + 1) / 2) {
                long sum = mid * (mid + 1) / 2;
                if(sum <= s){
                    left = mid + 1;
                    maxIdx = mid;  // mid 값을 저장
                } else {
                    right = mid - 1;
                }
            } else {
                right = mid - 1; // mid가 너무 커서 오버플로우가 발생할 가능성이 있을 때
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());

        long ans = binarySearch(s);

        System.out.println(ans);
    }
}
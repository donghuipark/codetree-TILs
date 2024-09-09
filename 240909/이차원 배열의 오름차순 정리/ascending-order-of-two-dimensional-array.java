import java.util.*;
import java.io.*;

public class Main {
    private static long n, k;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());
        int len = (int)(n*n);
        long[] arr = new long[len];
        int cnt=0;
        for(int i =1 ;i<=n;i++){
            for(int j = 1;j<=n;j++){
                arr[cnt++] = i*j;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[(int)k-1]);


    }
}
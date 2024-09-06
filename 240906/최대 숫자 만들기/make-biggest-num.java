import java.util.*;
import java.io.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i] = br.readLine(); 
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo((a+b)));

        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
}
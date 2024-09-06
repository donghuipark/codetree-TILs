import java.util.*;
import java.io.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (o1, o2) ->{
            return o1[1] - o2[1];
        });

        int ans = 1;
        int end = arr[0][1];

        for(int i=1;i<n;i++){
            if(arr[i][0] >= end){
                ans++;
                end = arr[i][1];
            }
        }
        System.out.println(ans);

    }
}
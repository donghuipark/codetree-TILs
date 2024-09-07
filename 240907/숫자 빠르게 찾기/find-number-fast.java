import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    private static int binarySearch(int num){
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] > num){
                right = mid - 1;
            }
            else if(arr[mid] < num){
                left = mid + 1;
            }
            else if(arr[mid] == num){
                return mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(br.readLine());

            System.out.println(binarySearch(num));
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] arr;

    private static boolean canBomb(int range){
        int bombUsed = 0; //폭탄 쓴 개수
        int i = 0; //점이 있는 인덱스

        while(i<n){ //모든 점을 돌아보자...
            bombUsed++;
            int coverage = arr[i] + 2*range; 

            while(i<n && arr[i] <= coverage){
                i++;
            }

            if(bombUsed > k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = max - min;
        int result = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canBomb(mid)){
                //반경이 너무 큰것같으니깐 줄여야할 것 같다.
                result = mid;
                right = mid - 1;
            }
            else{
                //반경이 너무 작아 늘려.
                left = mid + 1;
            }
        }
        System.out.println(result);
        
        
    }
}
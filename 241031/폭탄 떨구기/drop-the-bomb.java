import java.util.*;
import java.io.*;

public class Main{
    private static int n, k;
    private static int[] arr;

    private static boolean Bomb(int range){
        int bombUsed = 0;
        int index = 0;

        while(index<n){
            bombUsed++;
            int coverage = arr[index] + 2*range;

            //coverage범위가 더 크다.? 
            while(index<n && coverage >= arr[index]){
                index++;
            }
        }
        if(bombUsed > k){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int max = Integer.MIN_VALUE;
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

            if(Bomb(mid)){
                //현재범위로 너무 충분하게 깬다. 줄여
                result = mid;
                right = mid - 1;
            }
            else{
                //현재범위로 너무 부족하다 늘려.
                left = mid + 1;
            }
        }

        System.out.println(result);

    }
}
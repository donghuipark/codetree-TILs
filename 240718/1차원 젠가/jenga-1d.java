import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int s, e;
    private static int[] arr;
    private static int[] copy;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        


        for(int i=1 ;i<n+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int ir = 0; ir<2;ir++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for(int i = s; i<=e; i++){
                arr[i] = 0;
            }
            copy = new int[n+1];
           
            solution();
            
        }

        int size = 0;
        //출력 1. 남은 블록의 수, 위에서부터 남은블록 순서대로
        for(int i=1;i<n+1;i++){

            if(arr[i] == 0 ){
                System.out.println(size); 
                break;   
            }else{
                size++;
            }
        }

        for(int i=1; i<size+1;i++){
            System.out.println(arr[i]);
        }

    }
    private static void solution(){
        int tmp = 1;

        for(int i=1 ;i<n+1;i++){
            if(arr[i] != 0){
                copy[tmp] = arr[i];
                tmp++;
            }
        }
        arr = copy.clone();

    }
}
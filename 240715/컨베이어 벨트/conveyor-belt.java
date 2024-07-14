import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    private static int n, t;
    private static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        belt = new int[2][n];

        // 윗줄받기
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            belt[0][i] = Integer.parseInt(st.nextToken());
        }
        // 밑줄받기
        st = new StringTokenizer(br.readLine());
        for(int i=n-1;i>=0;i--){
            belt[1][i] = Integer.parseInt(st.nextToken());
        }

        //옮기기
    
        int tmp = belt[0][n-1];
        for(int i=n-1;i>0;i--){
            belt[0][i] = belt[0][i-1];
        }
        belt[0][0] = belt[1][0];

        for(int i=0;i<n-1;i++){
            belt[1][i] = belt[1][i+1];
        }
        belt[1][n-1] = tmp;

        //출력
        for(int i=0;i<n;i++){
            System.out.print(belt[0][i]+ " ");
        }
        System.out.println();
        for(int i=n-1;i>=0;i--){
            System.out.print(belt[1][i]+ " ");
        }
        
    }
}
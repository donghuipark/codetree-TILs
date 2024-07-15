import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    private static int n, t;
    private static int[][] belt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        belt = new int[3][n];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                belt[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        while(t-- >0){
            int tmp = belt[0][n-1];
            for(int i=n-1;i>0;i--){
                belt[0][i] = belt[0][i-1];
            }
            belt[0][0] = belt[2][n-1];

            for(int i=n-1;i>0;i--){
                belt[2][i] = belt[2][i-1];
            }
            belt[2][0]=belt[1][n-1];

            for(int i=n-1;i>0;i--){
                belt[1][i] = belt[1][i-1];
            }
            belt[1][0] = tmp;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                System.out.print(belt[i][j] + " ");
            }
            System.out.println();
        }
    }
}
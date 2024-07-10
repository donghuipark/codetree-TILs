import java.util.Scanner;

public class Main {
    public static int checkSum(int[][] grid, int start_i, int start_j){
        int sum = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                sum += grid[start_i+i][start_j+j];
            }
        }
        return sum;
    
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int answer =0 ;
        for(int i=0;i<=n-3; i++){
            for(int j=0 ;j<=n-3 ; j++){
                int sum = checkSum(grid, i, j);
                if(answer <sum){
                    answer = sum;
                }
            }
        }
        System.out.println(answer);


        sc.close();

    }
}
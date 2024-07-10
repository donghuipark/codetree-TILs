import java.util.Scanner;

    public class Main {
        public static int n;
        public static int m;
        public static int checkRow(int[][] grid, int r){
            
            int cnt = 0;
            int pre = grid[r][0];
            for(int i=0;i<n;i++){
                if(pre == grid[r][i]){
                    cnt++;
                    if(cnt == m){
                        return 1;
                    }
                }else{
                    pre = grid[r][i];
                    cnt =1;
                }
            }
            return 0;
        }
        public static int checkCol(int[][] grid, int c){
            
            int cnt =0;
            int pre = grid[0][c];
            for(int i=0; i<n;i++){
                if (pre == grid[i][c]) {
                    cnt++;
                    if (cnt == m) {
                        return 1;                   
                    }
                }else{
                    pre = grid[i][c];
                    cnt = 1;
                }
            }
            return 0;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();

            int[][] grid = new int[n][n];
            for(int i= 0 ;i<n; i++){
                for(int j=0;j<n;j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for(int i=0;i<n;i++){
                int sum_r = checkRow(grid,i);
                int sum_c = checkCol(grid,i);
                sum += sum_r + sum_c; 
            }
            System.out.println(sum);
            sc.close();
        }
    }
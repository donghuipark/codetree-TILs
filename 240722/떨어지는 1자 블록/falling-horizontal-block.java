import java.io.*;
import java.util.*;

public class Main{
    private static int n, m, k;
    private static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) -1;

        grid = new int[n][n];
        for(int i=0;i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =n-1; i>=0; i--){
            int start = solve(i);
            if (start != -1) {
                for(int j = start; j< start+m; j++){
                    grid[i][j] = 1;
                }
                break;
            }else{
                continue;
            }               
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int solve(int r){
        int cnt =0;
        int start = 0;
        for(int i=k;i<n;i++){
            if (grid[r][i] == 0) {
                cnt++;
                if (cnt == m) {
                    return start;
                }
            }else{
                start = i+1;    
            }
        }
        return -1;
    }
}
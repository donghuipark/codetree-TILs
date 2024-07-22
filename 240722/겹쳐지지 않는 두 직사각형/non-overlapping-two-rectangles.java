import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    private static int n,m;
    private static int[][] grid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        // 직사각형 먼저 정하자. 시작점(a,b), 끝점(c,d)
        for(int a=0; a<n; a++){
            for(int b=0; b<m; b++){
                for(int c=a; c<n; c++){
                    for(int d=b;d<m;d++){
                        //안겹치는 또다른 사각형 만드는거랑 비교하기.
                        max = Math.max(max, find_rect(a,b,c,d));
                    }
                }
            }
        }
        System.out.println(max);
    }
    private static int find_rect(int x1, int y1, int x2, int y2){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i; k<n;k++){
                    for(int l=j; l<m; l++){
                        if (!isOverLap(x1, y1, x2, y2, i, j, k, l)) {
                            max = Math.max(max, rect_sum(x1,y1,x2,y2)+rect_sum(i,j,k,l));                            
                        }
                    }
                }
            }
        }
        return max;
    }
    private static boolean isOverLap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        for(int a = x3; a<=x4; a++){
            for(int b = y3; b<=y4; b++){
                if (x1<=a && a <= x2 && y1 <= b && b <= y2) {
                    return true;                    
                }
            }
        }
        return false;
    }
    private static int rect_sum(int a, int b, int c, int d){
        int sum =0;
        for(int i=a; i<=c; i++){
            for(int j=b; j<=d; j++){
                sum += grid[i][j];
            }
        }
        return sum;
    }

}
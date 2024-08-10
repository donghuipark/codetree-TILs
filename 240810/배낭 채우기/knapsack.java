import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static int[] bag;
    private static int[][] jewel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bag = new int[m+1];
        jewel = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                jewel[i][j] = Integer.parseInt(st.nextToken());
            }    
        }

        for(int i=0;i<=m;i++){
            bag[i] = Integer.MIN_VALUE;
        }
        bag[0] = 0;

        for(int i=0;i<n;i++){//jewel weight, value
            for(int j=m;j>=0;j--){//bag weight
                if (j >= jewel[i][0]) {
                    if (bag[j-jewel[i][0]] != Integer.MIN_VALUE) {
                        bag[j] = Math.max(bag[j], bag[j-jewel[i][0]] + jewel[i][1]);
                    }
                }
            }
        }
        System.out.println(bag[m]);
    }
}
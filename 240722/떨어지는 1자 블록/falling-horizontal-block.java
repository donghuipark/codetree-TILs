import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        down();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void down() {
        int row = getRowPosition();

        for (int j=k; j<k+m; j++) {
            arr[row][j] = 1;
        }
    }

    private static int getRowPosition() {
        for (int i=0; i<n-1; i++) {
            boolean isUpBlank = true;
            boolean isDownBlank = true;
            for (int j=k; j<k+m; j++) {
                if (arr[i][j] == 1) {
                    isUpBlank = false;
                    break;
                }

                if (arr[i+1][j] == 1) {
                    isDownBlank = false;
                    break;
                }
            }

            if (isUpBlank && !isDownBlank) {
                return i;
            }
        }

        return n-1;
    }
}
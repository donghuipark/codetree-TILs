import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] graph;
    private static boolean[] visited;
    private static int ans;

    private static void dfs(int Vertex){
        for(int i = 0; i<n; i++){
            if (graph[Vertex][i] == 1 && !visited[i]) {
                visited[i] = true;
                ans++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        visited = new boolean[n];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        visited[0] = true;
        dfs(0);
        System.out.println(ans);
    }
}
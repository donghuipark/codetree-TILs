import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map, direction = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int n, MAX_LEN = 21;
    public static Queue<int[]> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1;
            queue.offer(new int[]{r, c});
        }
        for(int i=0; i<t; i++) {
            move();
        }
        System.out.print(queue.size());
        br.close();
    }

    public static void move() {
        Set<Integer> set = new HashSet<>(), removes = new HashSet<>();
        int size = queue.size();
        for(int i=0; i<size; i++) {
            int[] pos = queue.poll();

            int r=0, c=0, max = -1;
            for(int j=0; j<direction.length; j++) {
                int nextR = pos[0] + direction[j][0];
                int nextC = pos[1] + direction[j][1];
                if(isRange(nextR, nextC) && map[nextR][nextC] >= max) {
                    r = nextR;
                    c = nextC;
                    max = map[r][c];
                }
            }
            int key = r*MAX_LEN + c;
            if(set.contains(key)) removes.add(key);
            set.add(key);
            queue.offer(new int[]{r, c});
        }
        size = queue.size();
        for(int i=0; i<size; i++) {
            int[] pos = queue.poll();
            if(removes.contains(pos[0]*MAX_LEN + pos[1])) continue;
            queue.offer(pos);
        }
    }

    public static boolean isRange(int r, int c) {
        return r>=0 && r<n && c>=0 && c<n;
    }
}
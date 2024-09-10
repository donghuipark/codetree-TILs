import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static long[][] segments;

    // 주어진 거리(distance)로 점을 배치할 수 있는지 시뮬레이션하는 함수
    private static long simulate(long distance) {
        long cnt = 1; // 첫 번째 점을 첫 번째 선분에 배치
        long lastPlaced = segments[0][0]; // 첫 번째 점의 위치

        // 모든 선분을 돌며 점을 배치
        for (int i = 0; i < m; i++) {
            long start = segments[i][0];
            long end = segments[i][1];

            // 현재 선분에서 가능한 만큼 거리만큼 떨어진 곳에 점을 배치
            if (lastPlaced < start) {
                lastPlaced = start; // 점을 현재 선분의 시작점으로 이동
            }

            while (lastPlaced + distance <= end) {
                lastPlaced += distance;
                cnt++;

                if (cnt >= n) {
                    return cnt; // 점을 모두 배치했으면 종료
                }
            }
        }
        return cnt; // 배치된 점의 개수를 반환
    }

    // 이진 탐색을 사용하여 가장 가까운 두 점 사이의 거리의 최댓값을 찾는 함수
    private static long binarySearch(int target) {
        long left = 1;
        long right = segments[m-1][1] - segments[0][0]; // 가능한 최대 거리
        long ans = -1;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (simulate(mid) >= target) {
                ans = mid; // 가능한 거리이므로 저장하고, 더 큰 거리로 시도
                left = mid + 1;
            } else {
                right = mid - 1; // 불가능하면 더 작은 거리로 시도
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 점의 개수
        m = Integer.parseInt(st.nextToken()); // 선분의 개수

        segments = new long[m][2]; // 선분의 시작과 끝을 저장할 배열

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            segments[i][0] = s;
            segments[i][1] = e;
        }

        // 선분들을 시작점을 기준으로 정렬
        Arrays.sort(segments, (o1, o2) -> Long.compare(o1[0], o2[0]));

        // 가장 가까운 두 점 사이의 거리의 최댓값을 출력
        System.out.println(binarySearch(n));
    }
}
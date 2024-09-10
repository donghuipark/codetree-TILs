import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static long[][] arr;

    private static long simulate(long distance) {
        long cnt = 1; // 첫 번째 점을 첫 번째 선분에 배치
        long lastPlaced = arr[0][0]; // 첫 번째 점의 위치

        // 모든 선분을 돌며 점을 배치
        for (int i = 0; i < m; i++) {
            long start = arr[i][0];
            long end = arr[i][1];

            // 현재 선분에서 가능한 만큼 거리만큼 떨어진 곳에 점을 배치
            while (lastPlaced + distance <= end) {
                lastPlaced += distance;
                cnt++;

                if (cnt >= n) {
                    return cnt; // 점을 모두 배치했으면 반환
                }
            }

            // 현재 점이 다음 선분의 시작보다 앞에 있는 경우
            if (lastPlaced < start) {
                lastPlaced = start; // 점을 선분의 시작점에 배치
            }
        }
        return cnt;
    }

    // 이진 탐색을 사용하여 가장 가까운 두 점 사이의 거리의 최댓값을 찾는 함수
    private static long binarySearch(int target) {
        long left = 1;
        long right = arr[m-1][1] - arr[0][0];
        long ans = -1;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (simulate(mid) >= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
        }

        // 선분들을 시작점을 기준으로 정렬
        Arrays.sort(arr, (o1, o2) -> Long.compare(o1[0], o2[0]));

        // 가장 가까운 두 점 사이의 거리의 최댓값을 출력
        System.out.println(binarySearch(n));
    }
}
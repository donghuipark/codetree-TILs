import java.util.*;
import java.io.*;

public class Main {

    // 주어진 거리 distance로 N개의 점을 배치할 수 있는지 확인하는 함수
    private static boolean canPlacePoints(long distance, long[][] segments, int n, int m) {
        int count = 0;  // 배치한 점의 개수
        long lastPlaced = Long.MIN_VALUE;  // 마지막으로 점을 배치한 위치

        for (int i = 0; i < m; i++) {
            long start = segments[i][0];
            long end = segments[i][1];

            // 이 선분에서 점을 배치할 수 있는 위치를 찾음
            if (lastPlaced < start) {
                lastPlaced = start;  // 선분의 시작점에 점을 배치
                count++;  // 점 배치 카운트 증가
            }

            // distance 만큼 떨어진 곳에 점을 배치하는 과정
            while (lastPlaced + distance <= end) {
                lastPlaced += distance;
                count++;
                if (count >= n) {
                    return true;  // N개의 점을 모두 배치할 수 있으면 true 반환
                }
            }
        }

        return count >= n;  // N개의 점을 모두 배치할 수 있으면 true 반환
    }

    // 이진 탐색을 통해 가장 가까운 두 점 사이의 거리의 최댓값을 찾는 함수
    private static long binarySearch(long[][] segments, int n, int m) {
        long left = 1;  // 최소 거리
        long right = segments[m - 1][1] - segments[0][0];  // 가능한 최대 거리
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canPlacePoints(mid, segments, n, m)) {
                answer = mid;  // 배치 가능하면 정답 후보로 저장
                left = mid + 1;  // 더 큰 거리로 시도
            } else {
                right = mid - 1;  // 더 작은 거리로 시도
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 점의 개수
        int m = Integer.parseInt(st.nextToken());  // 선분의 개수

        long[][] segments = new long[m][2];  // 선분의 시작점과 끝점을 저장할 배열

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            segments[i][0] = start;
            segments[i][1] = end;
        }

        // 선분들을 시작점을 기준으로 정렬
        Arrays.sort(segments, Comparator.comparingLong(o -> o[0]));

        // 가장 가까운 두 점 사이의 거리의 최댓값을 출력
        System.out.println(binarySearch(segments, n, m));
    }
}
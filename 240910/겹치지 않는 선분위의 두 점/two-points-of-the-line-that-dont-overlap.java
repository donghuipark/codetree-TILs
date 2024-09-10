import java.util.*;

public class Main {
    static int N, M;
    static List<long[]> segments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt(); // 점의 개수
        M = sc.nextInt(); // 선분의 개수

        // 선분 입력 받기
        for (int i = 0; i < M; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            segments.add(new long[] {a, b});
        }

        // 선분들을 시작점 기준으로 정렬
        segments.sort(Comparator.comparingLong(o -> o[0]));

        // 이진 탐색 범위 설정
        long left = 1; // 최소 거리
        long right = (long) 1e18; // 최대 거리 (최대 범위의 차이)

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canPlacePoints(mid)) {
                answer = mid; // mid 값이 가능하다면 더 큰 값도 가능할 수 있으므로 저장
                left = mid + 1; // 더 큰 값을 탐색
            } else {
                right = mid - 1; // mid 값이 불가능하면 더 작은 값을 탐색
            }
        }

        // 결과 출력
        System.out.println(answer);
    }

    // 주어진 거리로 N개의 점을 배치할 수 있는지 확인하는 함수
    static boolean canPlacePoints(long distance) {
        long lastPoint = Long.MIN_VALUE; // 마지막으로 배치한 점의 위치
        int pointsPlaced = 0; // 배치된 점의 개수

        // 모든 선분에 대해 점을 배치
        for (long[] segment : segments) {
            long start = Math.max(segment[0], lastPoint + distance); // 가능한 첫 배치 위치
            while (start <= segment[1]) { // 선분 내에서 점을 배치
                pointsPlaced++;
                lastPoint = start; // 마지막으로 배치된 점의 위치 갱신
                if (pointsPlaced >= N) return true; // N개의 점을 모두 배치했으면 true 반환
                start += distance; // 다음 점 배치
            }
        }

        return pointsPlaced >= N; // 배치된 점이 N개 이상인지 확인
    }
}
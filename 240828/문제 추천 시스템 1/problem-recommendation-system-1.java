import java.util.*;

public class Main {
    // 문제 정보를 저장할 맵 (문제 번호 -> 난이도)
    private static Map<Integer, Integer> problemMap = new HashMap<>();
    // 최대 힙 (난이도가 높은 문제를 빠르게 찾기 위해 사용)
    private static PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
    // 최소 힙 (난이도가 낮은 문제를 빠르게 찾기 위해 사용)
    private static PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // 초기 문제 리스트를 입력 받음
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int l = scanner.nextInt();
            addProblem(p, l);
        }

        int m = scanner.nextInt();
        // 명령어를 입력받고 처리
        for (int i = 0; i < m; i++) {
            String command = scanner.next();
            if (command.equals("ad")) {
                int p = scanner.nextInt();
                int l = scanner.nextInt();
                addProblem(p, l);
            } else if (command.equals("sv")) {
                int p = scanner.nextInt();
                int l = scanner.nextInt();
                removeProblem(p, l);
            } else if (command.equals("rc")) {
                int x = scanner.nextInt();
                if (x == 1) {
                    System.out.println(recommendMax());
                } else {
                    System.out.println(recommendMin());
                }
            }
        }

        scanner.close();
    }

    // 문제를 추가하는 메서드
    private static void addProblem(int p, int l) {
        problemMap.put(p, l);
        maxHeap.offer(new int[]{p, l});
        minHeap.offer(new int[]{p, l});
    }

    // 문제를 삭제하는 메서드
    private static void removeProblem(int p, int l) {
        problemMap.remove(p);
    }

    // 난이도가 가장 높은 문제를 추천하는 메서드
    private static int recommendMax() {
        while (!problemMap.containsKey(maxHeap.peek()[0]) || problemMap.get(maxHeap.peek()[0]) != maxHeap.peek()[1]) {
            maxHeap.poll();
        }
        return maxHeap.peek()[0];
    }

    // 난이도가 가장 낮은 문제를 추천하는 메서드
    private static int recommendMin() {
        while (!problemMap.containsKey(minHeap.peek()[0]) || problemMap.get(minHeap.peek()[0]) != minHeap.peek()[1]) {
            minHeap.poll();
        }
        return minHeap.peek()[0];
    }
}
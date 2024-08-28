import java.util.*;

public class Main {
    // 문제 정보를 저장할 맵 (문제 번호 -> 난이도)
    private static Map<Integer, Integer> problemMap = new HashMap<>();
    // 난이도와 문제 번호를 저장할 TreeSet (자동 정렬)
    private static TreeSet<int[]> problemSet = new TreeSet<>((a, b) -> {
        if (a[1] == b[1]) {
            return a[0] - b[0]; // 난이도가 같으면 문제 번호로 정렬
        }
        return a[1] - b[1]; // 기본적으로 난이도 순으로 정렬
    });

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
        // 이미 있는 문제라면 기존의 문제를 삭제하고 갱신
        if (problemMap.containsKey(p)) {
            removeProblem(p, problemMap.get(p));
        }
        // 문제를 추가
        problemMap.put(p, l);
        problemSet.add(new int[]{p, l});
    }

    // 문제를 삭제하는 메서드
    private static void removeProblem(int p, int l) {
        problemMap.remove(p);
        problemSet.remove(new int[]{p, l});
    }

    // 난이도가 가장 높은 문제를 추천하는 메서드
    private static int recommendMax() {
        return problemSet.last()[0];
    }

    // 난이도가 가장 낮은 문제를 추천하는 메서드
    private static int recommendMin() {
        return problemSet.first()[0];
    }
}
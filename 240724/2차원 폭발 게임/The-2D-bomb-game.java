import java.util.Scanner;

public class Main {

    static int n, m, k; // m개 이상
    static int[][] arr = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // solution
        if (m == 1) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 0; i < k; i++) {
            while (PossibleToExplode()) {
                Explode();
                Drop();
            }

            Rotate();
            Drop();

            while (PossibleToExplode()) {
                Explode();
                Drop();
            }
        }

        // output
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) answer++;
            }
        }
        System.out.println(answer);
    }

    static void Rotate() {
        int[][] tmp = new int[101][101];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                tmp[col][n - row - 1] = arr[row][col];
            }
        }

        // tmp를 다시 arr에 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }

    static void Drop() {
        for (int col = 0; col < n; col++) {
            // col번째 열에서 가장 아래 행에 있는 0 찾기
            int endOfIdx = -1;
            for (int row = n - 1; row > 0; row--) {
                if (arr[row][col] == 0) {
                    endOfIdx = row;
                    break;
                }
            }
            // 0이 없는 열이라면 그냥 넘어가기
            if (endOfIdx == -1) continue;

            // Swap
            for (int row = endOfIdx - 1; row >= 0; row--) {
                if (arr[row][col] != 0) {
                    arr[endOfIdx][col] = arr[row][col];
                    arr[row][col] = 0;
                    endOfIdx--;
                }
            }
        }
    }

    static void Explode() {
        for (int col = 0; col < n; col++) {
            int cnt = 1;
            for (int row = 0; row < n - 1; row++) {
                if (arr[row][col] == arr[row + 1][col]) {
                    cnt++;
                    continue;
                }

                if (cnt >= m) {
                    for (int idx = row - cnt + 1; idx <= row; idx++) {
                        arr[idx][col] = 0;
                    }
                }
                cnt = 1;
            }

            if (cnt >= m) {
                for (int idx = (n - 1) - cnt + 1; idx <= n - 1; idx++) {
                    arr[idx][col] = 0;
                }
            }
        }
    }

    static boolean PossibleToExplode() {
        for (int col = 0; col < n; col++) {
            int cnt = 1;
            for (int row = n - 1; row >= 0; row--) {
                if (arr[row][col] == 0 || row - 1 < 0) break;

                if (arr[row][col] == arr[row - 1][col]) cnt++;
                else cnt = 1;

                if (cnt >= m) return true;
            }
        }
        return false;
    }

    static void PrintArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
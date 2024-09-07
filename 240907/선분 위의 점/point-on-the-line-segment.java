import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] arr;

    // Lower bound: target보다 크거나 같은 첫 번째 점의 인덱스 반환
    private static int Lower(int target){
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Upper bound: target보다 작거나 같은 마지막 점의 인덱스 반환
    private static int Upper(int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 점들의 좌표를 정렬
        Arrays.sort(arr);

        // 각 선분에 대해 점의 개수를 계산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int minIdx = Lower(s); // s보다 크거나 같은 첫 번째 점
            int maxIdx = Upper(e); // e보다 작거나 같은 마지막 점

            // 점의 개수 계산
            if (minIdx > maxIdx) {
                System.out.println(0);
            } else {
                System.out.println(maxIdx - minIdx + 1);
            }
        }
    }
}
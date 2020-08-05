import java.util.*;

public class Main {
    static boolean[] used;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        used = new boolean[N+1];
        ans = new int[M];
        printSequence(0, 1, N, M);
    }

    // 브루트 포스
    static void printSequence(int index, int start, int n, int m) {
        if (m == index) { // 재귀함수의 기저조건 : 마지막 자리 인덱스의 수까지 구하면 수열 1개 완성
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for (int i=start;i<=n;i++) {
            if (used[i] == false) { // 수를 사용하지 않은 경우에만 확인
                ans[index] = i; // 해당 차례의 인덱스에 수를 널기
                used[i] = true; // 중복 확인용
                printSequence(index+1, i+1, n, m); // 다음 인덱스 자리에 올 숫자들을 확인
                used[i] = false; // 위 재귀가 끝나면 해당 수가 들어가는 경우들은 모두 고려한 것임
            }
        }
    }
}

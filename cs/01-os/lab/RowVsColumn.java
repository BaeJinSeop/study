/**
 * 2차원 배열을 행 먼저(arr[i][j]) 돌 때와 열 먼저(arr[j][i]) 돌 때의 속도 차이.
 * 배열 크기: 10000 x 10000 int = 약 400MB
 *
 * 실행: java cs/01-os/lab/RowVsColumn.java
 */
public class RowVsColumn {
    static final int N = 10_000;

    public static void main(String[] args) {
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = i + j;

        // 첫 라운드는 JIT 컴파일 전이라 느릴 수 있어서 여러 번 돌린다
        for (int round = 1; round <= 5; round++) {
            long t0 = System.nanoTime();
            long rowSum = rowFirst(arr);
            long t1 = System.nanoTime();
            long colSum = columnFirst(arr);
            long t2 = System.nanoTime();

            if (rowSum != colSum) throw new AssertionError("합이 다름: " + rowSum + " vs " + colSum);

            long rowMs = (t1 - t0) / 1_000_000;
            long colMs = (t2 - t1) / 1_000_000;
            System.out.printf("round %d: 행 먼저 %5d ms, 열 먼저 %5d ms (%.1f배)%n",
                    round, rowMs, colMs, (double) colMs / Math.max(rowMs, 1));
        }
    }

    static long rowFirst(int[][] arr) {
        long sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum += arr[i][j];
        return sum;
    }

    static long columnFirst(int[][] arr) {
        long sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum += arr[j][i];
        return sum;
    }
}

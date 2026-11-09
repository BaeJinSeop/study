/*
 * [BOJ 0000] 문제 이름
 * https://www.acmicpc.net/problem/0000
 *
 * 유형:
 * 접근:
 * 복잡도: 시간 O(), 공간 O()
 * 막힌 점 / 실수:
 * 풀이 시간: 분 (힌트 사용: X)
 *
 * 실행: java BOJ_0000.java < input.txt
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        sb.append(n);

        System.out.print(sb);
    }
}

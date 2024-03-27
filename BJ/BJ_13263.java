package BJ;

import java.util.*;
import java.io.*;

public class BJ_13263 {

    static class fish {
        int distance;
        int x;
        int y;
    }

    static int[][] map;
    static int N;
    static int shark[];
    static int sharkSize = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if (map[i][k] == 9)
                    shark = new int[] { i, k };
            }
        }
        // 먹을 물고기 선택 - 먹을 수 있는 물고기 중 가장 가까운 것 - 만약 거리가 같은 물고기가 있다면 위쪽 , 왼쪽에 있는 물고기부터 먹기
        // 물고기 위치를 저장하는 배열 만들기 - 위치가 저장, 거리 저장
        // 물고기를 먹고 나서 사이즈의 변화가 있으면 먹을 수 있는 물고기 업데이트하기

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int minSum = Integer.MAX_VALUE;
    public static int N;
    public static int M;
    public static int R;
    public static int cnt;
    public static boolean visited[];
    public static int calArr[][];

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력
        int arr[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 입력
        calArr = new int[R][3];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            calArr[i][0] = Integer.parseInt(st.nextToken());
            calArr[i][1] = Integer.parseInt(st.nextToken());
            calArr[i][2] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[R];
        find(0, arr);
        // System.out.println("Array :" + minSum);
        System.out.println(minSum);
    }

    public static void find(int cnt, int arr[][]) {
        int beforeArr[][] = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            beforeArr[i] = arr[i].clone();
        }
        if (cnt == R) {
            // 모든 케이스를 돈 경우로 배열의 값 최소 판단하기
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += arr[i][k];
                    // System.out.print(arr[i][k] + " ");
                }
                if (sum < minSum)
                    minSum = sum;
                // System.out.println();
            }
            // System.out.println("------------------");

        } else {
            // 모든 경우의 수를 돌리는데 이미 방문(연산)한 곳이면 연산 안하기
            for (int i = 0; i < R; i++) {
                if (!visited[i]) {
                    // System.out.println(cnt + " " + i);
                    rotate(i, arr);
                    visited[i] = true;
                    find(cnt + 1, arr);
                    for (int k = 0; k < beforeArr.length; k++) {
                        arr[k] = beforeArr[k].clone();
                    }
                    visited[i] = false;
                }
            }
            // 배열돌리고 다음케이스 불리기
        }
    }

    public static void rotate(int i, int arr[][]) {

        // 342
        int frontx = calArr[i][0] - calArr[i][2] - 1; // 0
        int fronty = calArr[i][1] - calArr[i][2] - 1; // 1
        int backx = calArr[i][0] + calArr[i][2] - 1; // 4
        int backy = calArr[i][1] + calArr[i][2] - 1; // 5

        int row = backy - fronty;
        int col = backx - frontx;

        for (int t = 0; t < Math.min(row, col) / 2; t++) {
            int tmp = arr[frontx + t][backy - t];
            // 오른쪽 row는 같고 col이 달라짐 끝에서 시작까지
            for (int k = backy - t; k > fronty + t; k--) {
                arr[t + frontx][k] = arr[t + frontx][k - 1];
            }
            // 위쪽
            for (int k = frontx + t; k < backx - t; k++) {
                // System.out.println(arr[k + 1][fronty + t] + " " + arr[k][fronty + t]);
                arr[k][fronty + t] = arr[k + 1][fronty + t];
            }
            // 왼쪽
            for (int k = fronty + t; k < backy - t; k++) {
                // System.out.println(arr[backx - t][k] + " " + arr[backx - t][k + 1]);
                arr[backx - t][k] = arr[backx - t][k + 1];
            }
            // 아래쪽
            for (int k = backx - t; k > frontx + 1 + t; k--) {
                // System.out.println(arr[k][backy - t] + " " + arr[k - 1][backy - t]);
                arr[k][backy - t] = arr[k - 1][backy - t];
            }
            // System.out.println("-" + (frontx + t + 1) + " " + (backy - t) + " " + tmp);
            arr[frontx + t + 1][backy - t] = tmp;
        }
    }
}
// 시작 시작col
// 시작지점 : calArr[i][0]-calArr[i][2], calArr[i][1] - calArr[i][2] 에서
// 끝 끝 col
// calArr[i][0]+calArr[i][2], calArr[i][1] + calArr[i][2]
// 시작지점에서 끝부분 높이 길이 구하는 공식 (calArr[][0]+calArr[][2])-(calArr[][0]-calArr[][2]+1)
// 시작지점에서 끝부분 가로 길이 구하는 공식 (calArr[][1] + calArr[][2]) - (calArr[][1] -
// calArr[][2])
// 돌리는 방법 오른쪽으로 밀기 위로 밀기 왼쪽으로 밀기 아래로 밀기 [ 위쪽 오른쪽 상단 값을 tmp에 담아야한다...... ]

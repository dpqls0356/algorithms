
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int R;

    public static void printArr(int arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void upDown(int arr[][]) {
        for (int i = 0; i < N / 2; i++) {
            int tmp[] = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = tmp;
        }

    }

    public static void leftRight(int arr[][]) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < M / 2; i++) {
                int tmp = arr[k][i];
                arr[k][i] = arr[k][M - i - 1];
                arr[k][M - i - 1] = tmp;
            }
        }
    }

    public static int[][] right90(int arr[][]) {
        int chArr[][] = new int[M][N];
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                // System.out.println("("+a+","+b+") ("+(N-b-1)+","+a+")");
                chArr[a][b] = arr[N - b - 1][a];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        return chArr;

    }

    public static int[][] left90(int arr[][]) {
        int chArr[][] = new int[M][N];
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                chArr[a][b] = arr[b][M - a - 1];
            }
        }
        // 여기서 arr = chArr로 하면 잘 안되던데 이유는 ?
        int tmp = N;
        N = M;
        M = tmp;
        return chArr;
    }

    public static void groupMoveClockwise(int arr[][]) {
        int firstBox[][] = new int[N / 2][M / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                firstBox[i][k] = arr[i][k];
            }
        }
        // 위로 이동 3사분면 -> 1사분면
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i][k] = arr[N / 2 + i][k];
            }
        }
        // 오른쪽으로 이동 4사분면 -> 3사분면
        for (int i = N / 2; i < N; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i][k] = arr[i][k + M / 2];
            }
        }
        // 아래로 이동 2사분면 -> 4사분면
        for (int i = 0; i < N / 2; i++) {
            for (int k = M / 2; k < M; k++) {
                arr[i + N / 2][k] = arr[i][k];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i][k + M / 2] = firstBox[i][k];
            }
        }
    }

    public static void groupMoveCounterClockwise(int arr[][]) {
        int firstBox[][] = new int[N / 2][M / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                firstBox[i][k] = arr[i][k];
            }
        }
        // 왼쪽 이동 1사분면 - > 2사분면
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i][k] = arr[i][k + M / 2];
            }
        }
        // 위로 이동 4사분면 -> 1사분면
        for (int i = 0; i < N / 2; i++) {
            for (int k = M / 2; k < M; k++) {
                arr[i][k] = arr[N / 2 + i][k];
            }
        }
        // 오른쪽으로 이동 4사분면 -> 3사분면
        for (int i = N / 2; i < N; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i][k + M / 2] = arr[i][k];
            }
        }
        // 아래로 이동 2사분면 -> 3사분면
        for (int i = 0; i < N / 2; i++) {
            for (int k = 0; k < M / 2; k++) {
                arr[i + N / 2][k] = firstBox[i][k];
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        String calStr = br.readLine();
        String[] cal = calStr.split(" ");
        for (int i = 0; i < R; i++) {
            if (cal[i].equals("1")) {
                upDown(arr);

            } else if (cal[i].equals("2")) {
                leftRight(arr);

            } else if (cal[i].equals("3")) {
                arr = right90(arr);

            } else if (cal[i].equals("4")) {
                arr = left90(arr);

            } else if (cal[i].equals("5")) {
                groupMoveClockwise(arr);

            } else if (cal[i].equals("6")) {
                groupMoveCounterClockwise(arr);

            }
        }
        printArr(arr);
    }

}

// switch (cal[i]) {
// case '1':
// upDown(arr);
// break;
// case '2':
// leftRight(arr);
// break;
// case '3':
// int[][] rchArr = right90(arr);
// arr = rchArr;
// break;
// case '4':
// int[][] lchArr = left90(arr);
// arr = lchArr;
// break;
// case '5':
// groupMoveClockwise(arr);
// break;
// case '6':
// groupMoveCounterClockwise(arr);
// break;
// }
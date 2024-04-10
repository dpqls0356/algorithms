import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int arr[][];
    static int calSize;
    static ArrayList<Integer> calList[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        calSize = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        calList = new ArrayList[calSize];
        for (int i = 0; i < calSize; i++) {
            calList[i] = new ArrayList<>();
        }
        visited = new boolean[calSize];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < calSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) {
                calList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        cal(0, arr);
        System.out.println(min);
    }

    public static void cal(int len, int rotateArr[][]) {
        if (len == calSize) {
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += rotateArr[i][k];
                    // System.out.print(rotateArr[i][k] + " ");
                }
                // System.out.println();
                if (min > sum)
                    min = sum;
            }
            // System.out.println("--------------");
        } else {
            for (int i = 0; i < calSize; i++) {
                if (!visited[i]) {
                    int[][] sendArr = new int[N][M];
                    for (int a = 0; a < N; a++) {
                        System.arraycopy(rotateArr[a], 0, sendArr[a], 0, M);
                    }
                    sendArr = rotate(i, sendArr);
                    visited[i] = true;
                    cal(len + 1, sendArr);
                    visited[i] = false;
                }
            }
        }
    }

    public static int[][] rotate(int calNumber, int changedArr[][]) {
        int startRow = calList[calNumber].get(0) - calList[calNumber].get(2) - 1;
        int startCol = calList[calNumber].get(1) - calList[calNumber].get(2) - 1;
        int endRow = calList[calNumber].get(0) + calList[calNumber].get(2) - 1;
        int endCol = calList[calNumber].get(1) + calList[calNumber].get(2) - 1;

        int line = (endRow - startRow) / 2;
        // System.out.println(line + " " + startRow + " " + startCol + " " + endRow + "
        // " + endCol);
        for (int i = 0; i < line; i++) {
            int lastInput = changedArr[startRow + i][endCol - i];
            for (int a = endCol - i; a > startCol + i; a--) {
                changedArr[startRow + i][a] = changedArr[startRow + i][a - 1];
            }
            // System.out.println("==========1=============");
            // for (int n = 0; n < N; n++) {
            // for (int m = 0; m < M; m++) {
            // System.out.print(changedArr[n][m] + " ");
            // }
            // System.out.println();
            // }
            ///////////////////////////////
            for (int a = startRow + i; a < endRow - i; a++) {
                changedArr[a][startCol + i] = changedArr[a + 1][startCol + i];
            }
            // System.out.println("==========2=============");
            // for (int n = 0; n < N; n++) {
            // for (int m = 0; m < M; m++) {
            // System.out.print(changedArr[n][m] + " ");
            // }
            // System.out.println();
            // }
            ///////////////////////

            for (int a = startCol + i; a < endCol - i; a++) {
                changedArr[endRow - i][a] = changedArr[endRow - i][a + 1];
            }
            // System.out.println("==========3=============");
            // for (int n = 0; n < N; n++) {
            // for (int m = 0; m < M; m++) {
            // System.out.print(changedArr[n][m] + " ");
            // }
            // System.out.println();
            // }
            //////////////////////////
            for (int a = endRow - i; a > startRow + i; a--) {
                changedArr[a][endCol - i] = changedArr[a - 1][endCol - i];
            }
            // System.out.println("==========4=============");
            // for (int n = 0; n < N; n++) {
            // for (int m = 0; m < M; m++) {
            // System.out.print(changedArr[n][m] + " ");
            // }
            // System.out.println();
            // }
            //////////////////////////
            changedArr[startRow + i + 1][endCol - i] = lastInput;
            // System.out.println("==========last=============");
            // for (int n = 0; n < N; n++) {
            // for (int m = 0; m < M; m++) {
            // System.out.print(changedArr[n][m] + " ");
            // }
            // System.out.println();
            // }
        }
        return changedArr;

    }
}
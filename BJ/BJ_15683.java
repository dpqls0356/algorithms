package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683 {
    static int N; // 공간 크기
    static int M; // 공간 크기
    static int space[][]; // 공간 정보를 담을 배열
    static int minSpace; // 최소 사각지대
    static int chspace; // 현재 cctv상태로 가지고 있는 사각지대
    static ArrayList<int[]> camera = new ArrayList<int[]>(); // 카메라 위치넣기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 공간의 크기 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        space = new int[N][M];
        minSpace = N * M; // 모든 공간이 사각지대라고 가정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                space[i][k] = Integer.parseInt(st.nextToken());
                // 0인 공간 수 카운트
                if (space[i][k] == 0)
                    chspace++;
                // 카메라 위치
                else if (space[i][k] != 6)
                    camera.add(new int[] { i, k });
            }
        }
        find();
        System.out.println(minSpace);
    }

    public static void find() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                System.out.print(space[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
        // 모든 카메라의 녹화공간을 파악한 경우
        if (camera.size() == 0) {
            if (minSpace > chspace)
                minSpace = chspace;
        } else {
            int cur[] = camera.remove(camera.size() - 1);
            int row = cur[0];
            int col = cur[1];
            int changeCnt[] = new int[4]; // 상하좌우
            // 카메라 번호가 1일때 -> 4번 돌리기 ->돌릴때마다 카메라 수 하나 줄이고 find호출해야함 ...
            if (space[row][col] == 1) {
                // 상
                changeCnt[0] = changeCnt[0] = up(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                // 하
                changeCnt[1] = changeCnt[1] = down(row, col);
                find();
                reDown(row, col, changeCnt[1]);
                // 좌
                changeCnt[2] = changeCnt[3] = left(row, col);
                find();
                reLeft(row, col, changeCnt[2]);
                // 우
                changeCnt[3] = changeCnt[2] = right(row, col);
                find();
                reRight(row, col, changeCnt[3]);
            }
            // 카메라 번호가 2일 때 -> 2번 돌리기
            if (space[row][col] == 2) {
                // 상하 -> find()
                changeCnt[0] = up(row, col);
                changeCnt[1] = down(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                reDown(row, col, changeCnt[1]);
                // 좌우 -> find()
                changeCnt[3] = left(row, col);
                changeCnt[2] = right(row, col);
                find();
                reLeft(row, col, changeCnt[3]);
                reRight(row, col, changeCnt[4]);
            }
            // 카메라 번호가 3일때 -> 4번 돌리기
            if (space[row][col] == 3) {
                // 상우 ->find()
                changeCnt[0] = up(row, col);
                changeCnt[2] = right(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                reRight(row, col, changeCnt[4]);
                // 우하 ->find()
                changeCnt[2] = right(row, col);
                changeCnt[1] = down(row, col);
                find();
                reRight(row, col, changeCnt[4]);
                reDown(row, col, changeCnt[1]);
                // 하좌 ->find()
                changeCnt[1] = down(row, col);
                changeCnt[3] = left(row, col);
                find();
                reDown(row, col, changeCnt[1]);
                reLeft(row, col, changeCnt[3]);
                // 좌상 ->find()
                changeCnt[3] = left(row, col);
                changeCnt[0] = up(row, col);
                find();
                reLeft(row, col, changeCnt[3]);
                reUp(row, col, changeCnt[0]);
            }
            // 카메라 번호가 4일때 -> 4번 돌리기
            if (space[row][col] == 4) {
                // 상좌우 -> find
                changeCnt[3] = left(row, col);
                changeCnt[0] = up(row, col);
                changeCnt[2] = right(row, col);
                find();
                reLeft(row, col, changeCnt[3]);
                reUp(row, col, changeCnt[0]);
                reRight(row, col, changeCnt[4]);
                // 상우하 -> find
                changeCnt[0] = up(row, col);
                changeCnt[2] = right(row, col);
                changeCnt[1] = down(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                reRight(row, col, changeCnt[4]);
                reDown(row, col, changeCnt[1]);
                // 우좌하 -> find
                changeCnt[2] = right(row, col);
                changeCnt[3] = left(row, col);
                changeCnt[1] = down(row, col);
                find();
                reRight(row, col, changeCnt[4]);
                reLeft(row, col, changeCnt[3]);
                reDown(row, col, changeCnt[1]);
                // 상하좌 -> find
                changeCnt[0] = up(row, col);
                changeCnt[1] = down(row, col);
                changeCnt[3] = left(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                reDown(row, col, changeCnt[1]);
                reLeft(row, col, changeCnt[3]);
            }
            // 카메라 번호가 5번
            if (space[row][col] == 5) {
                // 위로 이동 row-1~0까지 돌리기
                changeCnt[0] = up(row, col);
                // 아래로 이동
                changeCnt[1] = down(row, col);
                // 오른쪽 이동
                changeCnt[2] = right(row, col);
                // 왼쪽이동
                changeCnt[3] = left(row, col);
                find();
                reUp(row, col, changeCnt[0]);
                reDown(row, col, changeCnt[1]);
                reRight(row, col, changeCnt[4]);
                reLeft(row, col, changeCnt[3]);

            }
            // camera.add(new int[] {col,row});
        }

    }

    public static int up(int row, int col) {
        int cnt = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (space[i][col] == 6)
                break;
            else if (space[i][col] == 0) {
                chspace--;
                cnt++;
                space[i][col] = 7;
            }
        }
        return cnt;
    }

    public static int down(int row, int col) {
        int cnt = 0;
        for (int i = row + 1; i < N; i++) {
            if (space[i][col] == 6)
                break;
            else if (space[i][col] == 0) {
                chspace--;
                cnt++;
                space[i][col] = 7;
            }
        }
        return cnt;
    }

    public static int right(int row, int col) {
        int cnt = 0;
        for (int i = col + 1; i < M; i++) {
            if (space[row][i] == 6)
                break;
            else if (space[row][i] == 0) {
                chspace--;
                cnt++;
                space[row][i] = 7;
            }
        }
        return cnt;
    }

    public static int left(int row, int col) {
        int cnt = 0;
        for (int i = col - 1; i >= 0; i--) {
            if (space[row][i] == 6)
                break;
            else if (space[row][i] == 0) {
                chspace--;
                cnt++;
                space[row][i] = 7;
            }
        }
        return cnt;
    }

    public static void reUp(int row, int col, int cnt) {
        System.out.println(cnt);
        for (int i = row - 1; i > row - 1 - cnt; i--) {
            System.out.println(i);
            if (space[i][col] == 6)
                break;
            else if (space[i][col] == 7) {
                chspace++;
                space[i][col] = 0;
            }
        }
    }

    public static void reDown(int row, int col, int cnt) {
        for (int i = row + 1; i < row + 1 + cnt; i++) {
            if (space[i][col] == 6)
                break;
            else if (space[i][col] == 7) {
                chspace++;
                space[i][col] = 0;
            }
        }
    }

    public static void reRight(int row, int col, int cnt) {
        for (int i = col + 1; i <= col + cnt; i++) {
            if (space[row][i] == 6)
                break;
            else if (space[row][i] == 7) {
                chspace++;
                space[row][i] = 0;
            }
        }

    }

    public static void reLeft(int row, int col, int cnt) {
        for (int i = col - 1; i >= col - cnt; i--) {
            if (space[row][i] == 6)
                break;
            else if (space[row][i] == 7) {
                chspace++;
                space[row][i] = 0;
            }
        }
    }
}

// 되돌아갈때 되돌아가면 안되는 부분까지 같이 돌아가버림

// 각 카메라에서 방향을 정하고 카메라 개수 만큼 방향 정하면 그때 나아가고 빈 공간을 체크해야할 듯
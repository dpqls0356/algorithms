import java.util.*;
import java.io.*;

public class Solution {
    static int map[][];
    static ArrayList<int[]> core;
    static int maxCore;
    static int minLen;
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            core = new ArrayList<>();
            int curCore = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[i][k] = Integer.parseInt(st.nextToken());
                    if (map[i][k] == 1) {
                        // 가장자리에 있는 코어는 고려안함
                        if (i == 0 || i == N - 1 || k == 0 || k == N - 1)
                            curCore++;
                        // 가장자리에 있지않는 코어는 탐색이 필요
                        else
                            core.add(new int[] { i, k });
                    }
                }
            }

            maxCore = curCore;
            minLen = Integer.MAX_VALUE;
            findMin(0, curCore, 0);

            sb.append("#" + t + " " + minLen + "\n");

        }

        System.out.println(sb);

    }

    public static void findMin(int cnt, int curCore, int curLen) {
        if (cnt == core.size()) {
            updateCore(curCore, curLen);
        } else {
            // 미리 배열 카피해두기 - 막힌 길이면 나아갈 수 없기때문
            int copyCurLen = curLen;
            int copyMap[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, N);
            }

            // System.out.println("-------------map-------------");
            // for (int a = 0; a < N; a++) {
            // for (int b = 0; b < N; b++) {
            // System.out.print(copyMap[a][b] + " ");
            // }
            // System.out.println();
            // }

            int cur[] = core.get(cnt);
            int x = cur[0];
            int y = cur[1];
            // 사방탐색하기
            // 막혀있으면 코어 연결안되고 len도 늘릴 수 없다
            // 막혀있지않으면 코어 연결하고 len도 늘릴 수 있다.
            for (int i = 0; i < 4; i++) {
                boolean isOk = true;
                // 위
                if (i == 0) {
                    for (int k = x - 1; k >= 0; k--) {
                        if (map[k][y] == 0) {
                            map[k][y] = 2;
                            curLen++;
                        } else {
                            isOk = false;
                            break;
                        }
                    }
                }
                // 아래
                if (i == 1) {
                    for (int k = x + 1; k < N; k++) {
                        if (map[k][y] == 0) {
                            map[k][y] = 2;
                            curLen++;
                        } else {
                            isOk = false;
                            break;
                        }
                    }
                }
                // 왼쪽
                if (i == 2) {
                    for (int k = y - 1; k >= 0; k--) {
                        if (map[x][k] == 0) {
                            map[x][k] = 2;
                            curLen++;
                        } else {
                            isOk = false;
                            break;
                        }
                    }
                }

                // 오른쪽
                if (i == 3) {
                    for (int k = y + 1; k < N; k++) {
                        if (map[x][k] == 0) {
                            map[x][k] = 2;
                            curLen++;
                        } else {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    findMin(cnt + 1, curCore + 1, curLen);
                } else if (!isOk && maxCore <= curCore + core.size() - cnt) {
                    for (int k = 0; k < N; k++) {
                        System.arraycopy(copyMap[k], 0, map[k], 0, N);
                    }
                    findMin(cnt + 1, curCore, copyCurLen);
                }
                curLen = copyCurLen;
                for (int k = 0; k < N; k++) {
                    System.arraycopy(copyMap[k], 0, map[k], 0, N);
                }
            }
        }
    }

    public static void updateCore(int curCore, int curLen) {
        // 코어가 같을 경우 작은 전선 수로 업데이트
        // 코어가 다를 경우 무조건 많은 코어의 전선 수로 업데이트
        // System.out.println("maxCore:" + maxCore + " curCore:" + curCore + " minLen:"
        // + minLen + " curLen:" + curLen);
        if (curCore == maxCore) {
            if (minLen > curLen) {
                minLen = curLen;
            }
        } else if (curCore > maxCore) {
            minLen = curLen;
            maxCore = curCore;
        }
    }
}

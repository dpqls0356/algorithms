import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int maxCore;
    static int cntCore;
    static int minLen;
    static ArrayList<int[]> core;
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            maxCore = Integer.MIN_VALUE;
            cntCore = 0;
            minLen = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            // 코어의 위치 저장
            core = new ArrayList<>();

            // 셀정보받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][k] == 1)
                        core.add(new int[] { i, k });
                }
            }
            find(0, arr, 0);
            sb.append("#" + t + " " + minLen + "\n");
        }
        System.out.print(sb);
    }

    // cnt = 탐색한 코어 수 , 배열
    static void find(int cnt, int spot[][], int cntLen) {
        // 출력
        int originLen = cntLen;
        int originSpot[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(spot[i], 0, originSpot[i], 0, N);
        }
        // System.out.println("----------copy----------");
        // for (int i = 0; i < N; i++) {
        // for (int k = 0; k < N; k++) {
        // System.out.print(originSpot[i][k] + " ");
        // }
        // System.out.println();
        // }
        // 모든 코어를 다 고려한 경우
        if (cnt == core.size()) {
            // System.out.println("len: " + cntLen + " core" + cntCore);
            // for (int i = 0; i < N; i++) {
            // for (int k = 0; k < N; k++) {
            // System.out.print(spot[i][k] + " ");
            // }
            // System.out.println();
            // }
            if (maxCore == cntCore) {
                if (minLen > cntLen)
                    minLen = cntLen;
            } else if (maxCore < cntCore) {
                minLen = cntLen;
                maxCore = cntCore;
            }
        } else {
            int curCore[] = core.get(cnt);
            int curx = curCore[0];
            int cury = curCore[1];
            // System.out.println(curx + " -------- " + cury);
            // 코어가 가장자리에 있을 때
            if (curx == 0 || curx == N - 1) {
                cntCore++;
                find(cnt + 1, spot, cntLen);
                cntCore--;
            } else {
                // 코어가 가장자리에 있지않을 때
                for (int i = 0; i < 4; i++) {
                    boolean ch = true;
                    if (i == 0) {
                        for (int k = curx - 1; k >= 0; k--) {
                            if (spot[k][cury] == 0) {
                                cntLen++;
                                spot[k][cury] = 2;
                            } else {
                                ch = false;
                                break;
                            }
                        }
                    } else if (i == 1) {
                        for (int k = curx + 1; k < N; k++) {
                            if (spot[k][cury] == 0) {
                                cntLen++;
                                spot[k][cury] = 2;
                            } else {
                                ch = false;
                                break;
                            }
                        }
                    } else if (i == 2) {
                        for (int k = cury - 1; k >= 0; k--) {
                            if (spot[curx][k] == 0) {
                                cntLen++;
                                spot[curx][k] = 2;
                            } else {
                                ch = false;
                                break;
                            }
                        }
                    } else if (i == 3) {
                        for (int k = cury + 1; k < N; k++) {
                            if (spot[curx][k] == 0) {
                                cntLen++;
                                spot[curx][k] = 2;
                            } else {
                                ch = false;
                                break;
                            }
                        }
                    }
                    if (ch) {
                        cntCore++;
                        find(cnt + 1, spot, cntLen);
                        cntCore--;
                    }  else if(maxCore<=core.size()-cnt+cntCore) {
                        	 find(cnt + 1, originSpot, originLen);
                         }
                    for (int a = 0; a < N; a++) {
                        System.arraycopy(originSpot[a], 0, spot[a], 0, N);
                    }
                    cntLen = originLen;
                }

            }
        }
    }
}
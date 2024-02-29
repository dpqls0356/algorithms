
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int maxCore; 	//최대 코어 수
    static int cntCore;		//현재 코어 수
    static int minLen;		//최소 전선 길이
    static ArrayList<int[]> core;	// 코어 위치를 담을 변수
    static int N;			// 배열의 크기
    static int coreSize;	//탐색해야하는 코어 개수

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());	//테케

        for (int t = 1; t <= T; t++) {
            maxCore = Integer.MIN_VALUE;	// 전역변수들 초기화
            cntCore = 0;					
            minLen = Integer.MAX_VALUE;
            
            //배열의 크기 입력 받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            
            
            // 셀정보받기 
            core = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    // 코어일 경우 위치 저장
                    if (arr[i][k] == 1) {
                    	//가장자리에 있는 코어의 수는 미리 더해두기
                    	if((i==0)||(i==N-1)||(k==0)||(k==N-1))cntCore++;
                    	else core.add(new int[] { i, k });
                    }
                }
            }

            maxCore = cntCore;
            // 탐색할 코어의 수 = 저장한 코어의 수
            coreSize = core.size();
            find(0, arr, 0);
            sb.append("#" + t + " " + minLen + "\n");
        }
        System.out.print(sb);
    }

    // cnt = 재귀 돌면서 탐색한 코어 수 , 배열, 카운트한 전선 길이
    static void find(int cnt, int spot[][], int cntLen) {
    	//원본 값 저장하기 - 탐색하다가 길 막히면 원본 값을 다음 재귀로 보내야함
        int originLen = cntLen;
        int originSpot[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(spot[i], 0, originSpot[i], 0, N);
        }
         
        // 모든 코어를 다 고려한 경우
        if (cnt == coreSize) {
        	// 카운트한 코어랑 최대 코어 수랑 같은 경우에 카운트한 전선의 길이가 짧으면 minLen업데이트
            if (maxCore == cntCore) {
                if (minLen > cntLen)
                    minLen = cntLen;
                // 카운트한 코어의 수가 더 많은 경우 minlen 업데이트하기
            } else if (maxCore < cntCore) {
                minLen = cntLen;
                maxCore = cntCore;
            }
            //모든 코어를 다 고려하지 못한 경우
        } else {
        	//탐색할 코어 가져오기
            int curCore[] = core.get(cnt);
            int curx = curCore[0];
            int cury = curCore[1];
            // 코어가 가장자리에 있을 때
            if (curx != 0 || curx != N - 1) {
                // 코어가 가장자리에 있지않을 때 - 가장 자리에 있는 경우 이미 43번라인에서 카운트함
                    for (int i = 0; i < 4; i++) {
                        boolean isConnected = true;
                        if (i == 0) {
                            for (int k = curx - 1; k >= 0; k--) {
                                if (spot[k][cury] == 0) {
                                    cntLen++;
                                    spot[k][cury] = 2;
                                } else {
                                	isConnected = false;
                                    break;
                                }
                            }
                        } else if (i == 1) {
                            for (int k = curx + 1; k < N; k++) {
                                if (spot[k][cury] == 0) {
                                    cntLen++;
                                    spot[k][cury] = 2;
                                } else {
                                	isConnected = false;
                                    break;
                                }
                            }
                        } else if (i == 2) {
                            for (int k = cury - 1; k >= 0; k--) {
                                if (spot[curx][k] == 0) {
                                    cntLen++;
                                    spot[curx][k] = 2;
                                } else {
                                	isConnected = false;
                                    break;
                                }
                            }
                        } else if (i == 3) {
                            for (int k = cury + 1; k < N; k++) {
                                if (spot[curx][k] == 0) {
                                    cntLen++;
                                    spot[curx][k] = 2;
                                } else {
                                	isConnected = false;
                                    break;
                                }
                            }
                        }
                        //해당 코어가 연결된 경우
                        if (isConnected) {
                            cntCore++;
                            find(cnt + 1, spot, cntLen);
                            cntCore--;                        	
                        }
                        // 어차피 해당 코어를 포함해서 못 돌면 코어 개수가 최대가 되지못하기에 아예 탐색을 안해버리기
                         else if(maxCore<=core.size()-cnt+cntCore) {
                        	 find(cnt + 1, originSpot, originLen);
                         }
                        
                        //원상복구
                        for (int a = 0; a < N; a++) {
                            System.arraycopy(originSpot[a], 0, spot[a], 0, N);
                        }
                        cntLen = originLen;
                    }
            }
        }
    }
}
// System.out.println("----------copy----------");
// for (int i = 0; i < N; i++) {
// for (int k = 0; k < N; k++) {
// System.out.print(originSpot[i][k] + " ");
// }
// System.out.println();
// }
// System.out.println("len: " + cntLen + " core" + cntCore);
// for (int i = 0; i < N; i++) {
// for (int k = 0; k < N; k++) {
// System.out.print(spot[i][k] + " ");
// }
// System.out.println();
// }
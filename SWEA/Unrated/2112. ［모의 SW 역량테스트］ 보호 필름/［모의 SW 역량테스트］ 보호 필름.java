import java.util.*;
import java.io.*;
 
public class Solution {
 
    static int D, W, K; // 막의 개수, 셀의 수 , 최소 기준
    static int[][] arr; // 보호필름
    static int[][] copy; // 보호필름
    static StringBuilder sb = new StringBuilder();
    static int minAdd; // 약품을 더하는 최소한의 수
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken()); // 테케
 
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[D][W];
            copy = new int[D][W];
            for (int i = 0; i < D; i++) { // 깊이
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < W; k++) { // 너비
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    copy[i][k] = arr[i][k];
                }
            }
                minAdd = D;
                DFS(0, 0); // 넣을지 안넣을지 선택한 홧수 , 넣은 약품 수 , 현재 보호필름 상태로 dfs돌리기
                System.out.println("#" + t + " " + minAdd);
             
        }
 
    }
 
    public static void DFS(int len, int add) {
        if (add >= minAdd)
            return;
        // 넣을지 안넣을지 전부 판단한 경우
        if (len == D) {
            if (checked()) { // 검사에 통과 되었을 때
                if (minAdd > add) {
                    minAdd = add;
                }
            }
        } else {
            // 안넣는 경우 이전 배열 그대로 쓰기 - 넣는 약품의 수를 최소화 하기 위함
            DFS(len + 1, add);
 
            // A를 넣는 경우 0
            for (int i = 0; i < W; i++) {
                arr[len][i] = 0;
            }
            DFS(len + 1, add + 1);
 
            // B를 넣는 경우 1
            for (int i = 0; i < W; i++) {
                arr[len][i] = 1;
            }
            DFS(len + 1, add + 1);
            for (int i = 0; i < W; i++) {
                arr[len][i] = copy[len][i];
            }
        }
    }
 
    public static boolean checked() {
        int check[] = new int[W]; // 걍 셸의 연속적인 숫자의 수
        for (int i = 0; i < W; i++) {
            int now = arr[0][i];
            int count = 0;
            for (int k = 0; k < D; k++) {
                if (now != arr[k][i] && count < K) { // 이전 셸의 상태와 달라졌고 이때까지 쌓인 연속적인 문자의 수가 K보다 작을 때 초기화
                    count = 1;
                    now = arr[k][i];
                } else {
                    count++;
                }
              if(count==K)break;
            }
            check[i] = count;
        }
 
        boolean pass = true;
        for (int i = 0; i < W; i++) {
            if (check[i] < K) {
                pass = false;
                break;
            }
        }
 
        return pass;
    }
}
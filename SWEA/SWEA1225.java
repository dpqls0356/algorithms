import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
    /**
     * 문제 : SWEA 1225
     * 작성자 : 이예빈
     * 알고리즘 : 큐
     * while()을 돌면서 큐에서 데이터를 하나 받아오기
     * 연산 이후 cnt가 6이 되면 0으로 바꿔주기
     * 연산 이후 데이터가 0보다 작으면 0으로 바꾸고 break;
     * 
     * 하 이 문제 오래 걸린 이유
     * 처음에 문제를 제대로 파악하지못함
     * -> 한 사이클에 최대 5까지만 뺄 수 있음을 놓침
     * -> 1,2,3,4,5...등의 숫자를 프로그램에서 제공하는 것이 아닌 사용자의 입력이었는데 오해했다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            // 테스트 케이스의 번호 받기
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            // 암호를 구하기 위한 큐 생성
            Queue<Integer> que = new LinkedList<Integer>();
            // 한 줄에 8개의 수 받기
            st = new StringTokenizer(br.readLine());
            // 분리하여 큐에 넣기
            for (int k = 0; k < 8; k++) {
                int inputNum = Integer.parseInt(st.nextToken());
                que.add(inputNum);
            }
            int cnt = 1;
            while (cnt < 9) {
                // 큐에서 데이터를 하나 받아오기
                int num = que.poll();
                num -= cnt;
                cnt++;
                // 연산 이후 cnt가 6이 되면 0으로 바꿔주기
                if (cnt == 6)
                    cnt = 1;
                // 연산 이후 데이터가 0보다 작으면 0으로 바꾸고 break;
                if (num <= 0) {
                    que.add(0);
                    break;
                } else {
                    que.add(num);
                }
            }
            // 결과 출력
            System.out.print("#" + i + " ");
            for (int k = 0; k < 8; k++) {
                System.out.print(que.poll() + " ");
            }
            System.out.println();
        }
    }
}

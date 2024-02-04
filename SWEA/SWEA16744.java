import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA16744 {
    /**
     * 문제 : SWEA16744
     * 작성자 : 이예빈
     * 문제 풀이 시간 : 약 45분
     * 결과 : 맞았습니다.
     * 메모리 :19216kb
     * 시간 : 105ms
     * 코드 길이 : 1263b
     * 
     * 풀이과정
     * 문제를 읽어보면 줄을 서고 peak 자리에 오게되면 다시 줄을 서기 위해 나가면서 마이쭈를 자신이 받았던 개수 + 1 받음
     * 큐를 사용해서 풀아
     * 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테케 받기
        int T = Integer.parseInt(st.nextToken());

        // 테케만큼 반복
        for (int i = 1; i <= T; i++) {

            // 마이쭈의 개수 입력 받기
            st = new StringTokenizer(br.readLine());
            int myChew = Integer.parseInt(st.nextToken());

            // 새로 추가되는 사람들의 인덱스
            int index = 1;

            // 줄 서는 공간 ? 을 나타내는 큐 생성
            Queue<Integer[]> que = new LinkedList<Integer[]>();

            // 1번 사람이 0개의 마이쭈를 받은 상태로 줄을 서게 된다.
            Integer[] arr = { index, 0 };
            que.add(arr);

            while (myChew > 0) {

                // peak에 위치 시 줄에서 나오면서 마이쭈를 받아감
                Integer[] pollArr = que.poll();
                pollArr[1] = pollArr[1] + 1;
                // 마이쭈를 준 만큼 나눌 수 있는 마이쭈 수 감소
                myChew -= pollArr[1];

                // 마이쭈 갯수가 0보다 작거나 같으면 해당 사람이 나가면서 마지막 마이쭈를 가져간 것으로
                // 인덱스 출력 후 break;
                if (myChew <= 0) {
                    System.out.println("#" + i + " " + (pollArr[0]));
                    break;
                }

                // 마이쭈의 개수가 남은 경우 다시 줄 세우기
                que.add(pollArr);

                // 새로운 사람 큐에 추가
                index++;
                Integer[] newArr = { index, 0 };
                que.add(newArr);
            }
        }
    }
}

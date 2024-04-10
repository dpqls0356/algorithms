
import java.util.*;
import java.io.*;

public class BJ1244 {
    /**
     * 문제 : 1244
     * 작성자 : 이예빈
     * 문제 풀이 시간 : 1시간 반 ㅠ
     * 결과 : 맞았습니다!!
     * 메모리 : 14604kb
     * 시간 : 148ms
     * 코드길이 : 3501B
     * 풀이과정
     * 
     * 오래걸린 이유
     * 만약 받은 숫자가 1번 스위치이거나 마지막 스위치일때 자기 자신만 바꾸고 continue해야하는데
     * 무슨 생각인지 break를 걸어버렸다.
     * 최고 멍청이 ...
     */

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int switchPcs = Integer.parseInt(st.nextToken());
        int classSwitch[] = new int[switchPcs + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchPcs; i++) {
            classSwitch[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int k = 1; k <= switchPcs; k++) {
                    if (k % num == 0) {
                        if (classSwitch[k] == 0)
                            classSwitch[k] = 1;
                        else if (classSwitch[k] == 1)
                            classSwitch[k] = 0;
                    }
                }
            } else if (gender == 2) {
                if (num == switchPcs || num == 1) {
                    if (classSwitch[num] == 0)
                        classSwitch[num] = 1;
                    else if (classSwitch[num] == 1)
                        classSwitch[num] = 0;
                    continue;
                }
                if (classSwitch[num] == 0)
                    classSwitch[num] = 1;
                else if (classSwitch[num] == 1)
                    classSwitch[num] = 0;
                int len = (num - 1 > switchPcs - num) ? switchPcs - num : num - 1;
                for (int k = 1; k <= len; k++) {
                    if (classSwitch[num - k] != classSwitch[num + k]) {
                        break;
                    } else {
                        if (classSwitch[num + k] == 0) {
                            classSwitch[num + k] = 1;
                            classSwitch[num - k] = 1;
                        } else if (classSwitch[num + k] == 1) {
                            classSwitch[num - k] = 0;
                            classSwitch[num + k] = 0;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= switchPcs; i++) {
            System.out.print(classSwitch[i] + " ");
            if (i % 20 == 0)
                System.out.println();
        }

    }

}
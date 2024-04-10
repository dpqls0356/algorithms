
import java.util.Scanner;

public class BJ_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 현재 시간의 시 받기
        int H = sc.nextInt();
        // 현재 시간의 분 받기
        int M = sc.nextInt();
        // 요리하는데 걸리는 시간 입력 받기
        int runTime = sc.nextInt();
        // 요리하는데 걸린 시간을 시와 분으로 분리
        int runTimeH = runTime / 60;
        int runTimeM = runTime % 60;

        // 분 판단
        // 현재 시간의 분 + 요리 시간의 분 의 값이 60분을 넘어간 경우
        if (runTimeM + M >= 60) {
            // 현재 시간의 분 + 요리 시간의 분 - 60
            M = runTimeM + M - 60;
            // 시를 1 늘려주기
            H++;
        }
        // 현재 시간의 분 + 요리 시간의 분 의 값이 60을 넘어가지않은 경우
        else {
            M = runTimeM + M;
        }

        // 시 판단
        // 현재 시간의 시 + 요리 시간의 시 의 값이 24시를 넘긴 경우
        if (H + runTimeH >= 24) {
            // 현재 시간의 시 + 요리 시간의 시 - 24
            H = H + runTimeH - 24;
        }
        // 현재 시간의 시 + 요리 시간의 시 의 값이 24시를 넘기지않은 경우
        else {
            H = H + runTimeH;
        }

        // 출력
        System.out.println((H) + " " + (M));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int foodCnt;
    public static int limitCal;
    public static int foods[];
    public static int cals[];
    public static int maxFoodTaste;
    public static int sumFoodTaste;
    public static int sumFoodCal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = (Integer.parseInt(st.nextToken()));
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            foodCnt = Integer.parseInt(st.nextToken());
            limitCal = Integer.parseInt(st.nextToken());
            foods = new int[foodCnt];
            cals = new int[foodCnt];
            for (int k = 0; k < foodCnt; k++) {
                st = new StringTokenizer(br.readLine());
                foods[k] = Integer.parseInt(st.nextToken());
                cals[k] = Integer.parseInt(st.nextToken());
            }
            maxFoodTaste = 0;
            sumFoodTaste = 0;
            sumFoodCal = 0;
            // 최고의 햄버거 만들러 가기 .........
            find(0);
            System.out.println("#" + (i + 1) + " " + maxFoodTaste);
        }

    }

    public static void find(int cnt) {
        if (cnt == foodCnt) {
            if (limitCal >= sumFoodCal) {
                if (sumFoodTaste > maxFoodTaste)
                    maxFoodTaste = sumFoodTaste;
            }
        } else {
            // 자신의 재료 포함 안하고 돌리기
            find(cnt + 1);
            // 자신의 재료 포함하고 돌리기 단, max를 넘어가지않는 경우만
            if (limitCal >= sumFoodCal + cals[cnt]) {
                sumFoodCal += cals[cnt];
                sumFoodTaste += foods[cnt];
                find(cnt + 1);
                sumFoodCal -= cals[cnt];
                sumFoodTaste -= foods[cnt];
            }

        }
    }
}

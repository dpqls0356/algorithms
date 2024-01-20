package ssafy_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0119 {
    public static void main(String[] args) throws IOException {

        /**
         * BJ_1259
         * 작성자 : 이예빈
         * 제출 : 2024.01.19
         * 결과 : 맞았습니다!!
         * 성능 요약 : 메모리 14048 kb, 시간 116 ms, 길이 736 b
         */
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;

        // while (true) {
        // st = new StringTokenizer(br.readLine());
        // String num = st.nextToken();
        // if (Long.parseLong(num) == 0) {
        // break;
        // }
        // for (int i = 0; i <= num.length() / 2; i++) {
        // if (num.charAt(i) != num.charAt(num.length() - i - 1) || num.charAt(0) ==
        // '0') {
        // System.out.println("no");
        // break;
        // }
        // if (i + 1 >= num.length() / 2) {
        // System.out.println("yes");
        // break;
        // }
        // }
        // }

        /**
         * BJ_1152
         * 작성자 : 이예빈
         * 제출 : 2024.01.19
         * 결과 : 맞았습니다!!
         * 성능 요약 : 메모리 31196 kb, 시간 512 ms, 길이 323 b
         */
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // int count = 0;
        // if (str.charAt(0) != ' ')
        // count++;
        // for (int i = 0; i < str.length() - 1; i++) {
        // if (str.charAt(i) == ' ') {
        // count++;
        // }
        // }
        // System.out.print(count);

        /**
         * BJ_1316
         * 작성자 : 이예빈
         * 제출 : 2024.01.19.23:10
         * 결과 : 맞았습니다!!
         * 성능 요약 : 메모리 17796kb, 시간 224ms, 길이782b
         * 접근법
         * >> 반복 횟수 : N
         * >> 한 단어가 그룹 단어인지 판단하기 -> 그룹단어란 해당 알파벳이 나온 뒤 다시는 안나오는 것
         * >> 한 글자가 나타나면 이미 나온건지아닌지 판단
         * >> 한 번도 안나온 글자라면 true
         * >> 연속일 경우 continue 이미 나왔는데 앞의 글자와 연속이 아닌경우 break;
         */
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int count = 0;

        // for (int i = 0; i < N; i++) {
        // String str = sc.next();
        // boolean visited[] = new boolean[(int) 'z' - (int) 'a' + 1];
        // for (int k = 0; k < str.length(); k++) {
        // if (visited[str.charAt(k) - 'a'] && str.charAt(k) != str.charAt(k - 1)) {
        // break;
        // }
        // if (!visited[str.charAt(k) - 'a']) {
        // visited[str.charAt(k) - 'a'] = true;
        // }
        // if (k + 1 == str.length())
        // count++;

        // }
        // }
        // System.out.println(count);

    }
}

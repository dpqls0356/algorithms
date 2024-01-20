package BJ;

import java.util.Scanner;

public class BJ_1316 {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            boolean visited[] = new boolean[(int) 'z' - (int) 'a' + 1];
            for (int k = 0; k < str.length(); k++) {
                if (visited[str.charAt(k) - 'a'] && str.charAt(k) != str.charAt(k - 1)) {
                    break;
                }
                if (!visited[str.charAt(k) - 'a']) {
                    visited[str.charAt(k) - 'a'] = true;
                }
                if (k + 1 == str.length())
                    count++;

            }
        }
        System.out.println(count);
    }
}

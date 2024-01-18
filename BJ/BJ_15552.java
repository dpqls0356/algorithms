package BJ;

import java.io.*;
import java.util.*;

public class BJ_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 출력을 하기위한 BufferedWriter 변수 선언, 객체 생성 및 할당
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력을 받을 횟수 설정
        int T = Integer.parseInt(st.nextToken());

        // 입력을 받아 bw에 결과값 넣기
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write((A + B) + "\n");

        }
        // bw에 담긴 데이터들을 한 번에 출력
        bw.flush();
        bw.close();

    }
}

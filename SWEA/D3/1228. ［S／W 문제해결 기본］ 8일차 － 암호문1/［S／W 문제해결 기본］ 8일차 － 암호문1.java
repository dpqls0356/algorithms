import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // 암호문 길이
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            // 암호문
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            // 명령어 개수
            st = new StringTokenizer(br.readLine());
            int calcnt = Integer.parseInt(st.nextToken());
            // 여러 명령어를 한 줄로 받기
            String cals = br.readLine();
            // I를 기준으로 문자열 분리 - calArr 한 공간엔 하나의 명령문만 존재.
            String calArr[] = cals.split("I");
            for (int k = 1; k < calcnt + 1; k++) {
                String arr[] = calArr[k].split(" ");
                int index = 3;
                for (int j = Integer.parseInt(arr[1]); j < Integer.parseInt(arr[1]) +
                        Integer.parseInt(arr[2]); j++) {
                    list.add(j, Integer.parseInt(arr[index]));
                    index++;
                }
            }
            sb.append("#" + (i + 1) + " ");
            for (int k = 0; k < 10; k++) {
                sb.append(list.get(k) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

package BJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 절대값이 가장 작은 것 출력 ( 음수가 먼저 ) / 0이면 출력
        PriorityQueue<Integer> pqu = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) {
                System.out.println(o1 > o2 ? 1 : -1);
                return o1 > o2 ? 1 : -1;
            }
            // 1이 크면 양수 리턴 -> 내림차순 / 2가 크면 음수리턴 -> 오름차순
            else
                return abs1 - abs2;

        });
        StringBuffer bf = new StringBuffer();

        int n = sc.nextInt();
        System.out.println("===========================");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (pqu.size() != 0)
                    bf.append(pqu.poll() + "\n");
                else
                    bf.append(0 + "\n");
            } else {
                pqu.add(num);
            }

        }
        System.out.print(bf.toString());
    }
}

// https://st-lab.tistory.com/243
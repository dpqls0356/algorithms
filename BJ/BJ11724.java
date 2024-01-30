package BJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ11724 {
    static boolean checkarr[];
    static ArrayList<Integer>[] ll;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int li = sc.nextInt();
        checkarr = new boolean[node + 1];
        ll = new ArrayList[node + 1];

        for (int i = 1; i < node + 1; i++) {
            ll[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < li + 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            ll[s].add(e);
            ll[e].add(s);
        }
        int count = 0;
        for (int i = 1; i < node + 1; i++) {
            // 방문이력이 없는경우 DFS 실행시키기
            if (!checkarr[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
        sc.close();
    }

    private static void DFS(int n) {
        // 방문 이력이 없는 경우 true로 바꾸고 해당 노드의 연결 노드들 DFS시키기
        if (!checkarr[n]) {
            {
                checkarr[n] = true;
                for (int i : ll[n]) {
                    if (!checkarr[i]) {
                        DFS(i);
                    }
                }
            }
        }
    }
}

// import java.util.Scanner;

// public class ex11724 {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// // 노드 수
// int node = sc.nextInt();
// // 간선 수
// int li = sc.nextInt();
// // 어떻게 연결되어있는지 넣을 배열
// int arr[][] = new int[li + 1][2];
// // 지나간 노드인지 확인하는 배열
// boolean checkarr[] = new boolean[node + 1];
// // 최상위 노드 수
// int count = 0;
// // 간선 입력하기
// for (int i = 1; i < li + 1; i++) {
// arr[i][0] = sc.nextInt();
// arr[i][1] = sc.nextInt();
// }
// // 0,0부터 시작
// int start = arr[1][0];
// int end = arr[1][1];
// // 간선 수 만큼 돌기
// for (int i = 1; i < li; i++) {
// // 처음 접근하는
// if (checkarr[start] == false) {
// checkarr[start] = true;
// if (checkarr[arr[i][1]] == false) {
// start = end;
// end = arr[i + 1][1];
// } else if (checkarr[end]) {
// start = arr[i + 1][0];
// end = arr[i + 1][1];
// count++;
// }
// } else {
// start = arr[i + 1][0];
// end = arr[i + 1][1];
// continue;
// }
// }
// System.out.println(count);
// sc.close();

// }
// }

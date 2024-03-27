package BJ;

import java.io.*;
import java.util.*;

/**
 * 문제번호 : BJ 11725
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 성능
 * 메모리 : 83236 KB , 시간: 1368 ms , 코드길이: 1669 B
 * 시간 : 1시간 8분
 * 38분 : 문제 분석 및 코딩 -> 냅다 시간초과 ㅋㅋ ..
 * 당연한게 그 전 코드는 2중 for문을 써버리니 발생할 수 밖에 없었다.
 * for (int i = 2; i <= node; i++) {
 * int parentNode = find(i);
 * sb.append(parentNode + "\n");
 * }
 * public static int find(int num) {
 * for (int i = 1; i < node + 1; i++) {
 * if (list[i].contains(num))
 * return i;
 * }
 * return 0;
 * }
 * 30분 : 어떻게 각 노드의 부모를 파악할지 고민, dfs사용해서 시간복잡도를 줄였다.
 * 
 */

public class BJ_11725 {

    public static ArrayList<Integer> list[]; // 트리 구조를 만들기 위한 ArrayList 배열
    public static int node; // 노드 수
    public static boolean visited[]; // 방문배열
    public static int childParent[]; // 자식노드(index)에 대한 부모노드(데이터)를 담는 배열

    // 부모 노드에 대한 자식노드 데이터들 저장
    public static void add(int parent, int child) {
        list[parent].add(child);
        list[child].add(parent);
    }

    // 부모노드를 찾는 함수
    public static void dfs(int curNode) {
        // 현재 노드(부모노드)를 기준으로 자식노드들을 찾는다.
        for (int i = 0; i < list[curNode].size(); i++) {
            int child = list[curNode].get(i);
            // 방문하지않은 자식노드이면
            if (!visited[child]) {
                // 해당 자식노드의 부모노드를 현재 노드로 저장
                childParent[child] = curNode;
                // 방문여부를 바꾸고
                visited[child] = true;
                // 해당 자식노드를 부모노드로 하여 dfs 호출
                dfs(child);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드의 수를 받고 각종 배열 초기화
        node = Integer.parseInt(st.nextToken());
        list = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        childParent = new int[node + 1];
        // 루트 노드는 방문했다고 지정하기
        visited[1] = true;
        for (int i = 1; i < node + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        // 입력을 받아 부모 노드에 대한 자식노드 데이터들 저장하는 함수 호출
        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            add(parent, child);
        }
        // 부모 노드를 찾기 위한 dfs 함수 호출
        dfs(1);
        // 결과 출력
        for (int i = 2; i < node + 1; i++) {
            System.out.println(childParent[i]);
        }
    }
}

// System.out.println("-----------------------------");
// for (int i = 1; i < node + 1; i++) {
// System.out.print(i + " ");
// for (int k = 0; k < list[i].size(); k++) {
// System.out.print(list[i].get(k) + " ");
// }
// System.out.println();
// System.out.println("-----------------------------");
// }

// 시간초과난 코드
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.StringTokenizer;

// public class Main {

// public static ArrayList<Integer> list[];
// public static int node;
// public static boolean visited[];

// public static void add(int parent, int child) {
// if (list[child].size() != 0 || visited[child]) {
// int tmp = parent;
// parent = child;
// child = tmp;
// }
// list[parent].add(child);
// visited[child] = true;
// }

// public static int find(int num) {
// for (int i = 1; i < node + 1; i++) {
// if (list[i].contains(num))
// return i;
// }
// return 0;
// }

// public static void main(String args[]) throws IOException {
// StringBuilder sb = new StringBuilder();
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// node = Integer.parseInt(st.nextToken());
// list = new ArrayList[node + 1];
// visited = new boolean[node + 1];
// visited[1] = true;
// for (int i = 1; i < node + 1; i++) {
// list[i] = new ArrayList<Integer>();
// }
// for (int i = 0; i < node - 1; i++) {
// st = new StringTokenizer(br.readLine());
// int parent = Integer.parseInt(st.nextToken());
// int child = Integer.parseInt(st.nextToken());
// add(parent, child);
// }
// for (int i = 2; i <= node; i++) {
// int parentNode = find(i);
// sb.append(parentNode + "\n");
// }
// System.out.print(sb.toString());
// }
// }
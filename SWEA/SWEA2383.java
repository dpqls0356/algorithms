import java.io.*;
import java.util.*;

public class SWEA2383 {
    static class Distance implements Comparable<Distance> {
        int number; // 사람번호
        int distance; // 현재 위치로부터 계단까지 거리

        public Distance(int number, int distance) {
            this.distance = distance;
            this.number = number;
        }

        @Override
        public int compareTo(Distance o) {
            return this.distance - o.distance;
        }
    }

    static class Person {
        // 이 사람의 고유 번호
        int number;
        // 이 사람의 초기 위치
        int x, y;

        public Person(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

    }

    static class Time {
        int wait; // 기다린시간
        int move; // 현재 이동한 시간
        int distance;

        public Time(int move, int wait, int distance) {
            this.move = move;
            this.wait = wait;
            this.distance = distance;
        }
    }

    static int N; // 배열의 크기
    static int minTime; // 최소 이동시간
    static ArrayList<Person> personList; // 사람들의 초기위치와 번호를 저장할 변수
    static ArrayList<Distance> distanceA; // 계단 1까지 가는데 걸리는 시간을 저장
    static ArrayList<Distance> distanceB; // 계단 2까지 가는데 걸리는 시간을 저장
    static ArrayList<Distance> selectedA; // 계단 1에 갈 사람들을 저장
    static ArrayList<Distance> selectedB; // 계단 2에 갈 사람들을 저장
    static boolean visited[]; // 특정 사람이 이동했는지 체크할 변수 (크기 N+1 : 1번 사람부터 존재)
    static ArrayList<int[]> step; // 계단 위치를 담을 변수
    static int arr[][]; // map정보를 담을 변수

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 테케 입력받기

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            personList = new ArrayList<>(); // 사람들의 정보를 저장할 리스트
            int personNum = 0; // 사람들에게 부여할 번호

            step = new ArrayList<>(); // 계단의 위치를 받기위한 변수
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[i][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][k] == 1) { // 사람이라면 정보를 리스트에 담기
                        personList.add(new Person(++personNum, i, k));
                    } else if (arr[i][k] != 0) { // 계단 위치 담기
                        step.add(new int[] { i, k, arr[i][k] });
                    }
                }
            }

            // 계단까지 거리 계산
            distanceA = new ArrayList<>();
            distanceB = new ArrayList<>();
            for (int i = 0; i < personList.size(); i++) {
                distanceA.add(new Distance(personList.get(i).number, Math.abs(personList.get(i).x - step.get(0)[0])
                        + Math.abs(personList.get(i).y - step.get(0)[1])));
                distanceB.add(new Distance(personList.get(i).number, Math.abs(personList.get(i).x - step.get(1)[0])
                        + Math.abs(personList.get(i).y - step.get(1)[1])));
            }
            Collections.sort(distanceA);

            // 계단 1에 사람이 다 몰렸을경우부터 진짜 다 돌려 ..?? 진짜로 ...?
            minTime = Integer.MAX_VALUE;
            selectedA = new ArrayList<>();
            selectedB = new ArrayList<>();
            visited = new boolean[personList.size() + 1];
            find(0);

            sb.append("#" + t + " " + minTime + "\n");
        }
        System.out.println(sb);
    }

    public static void find(int cnt) {
        // 사람들을 모두 분리해서 어떠한 계단으로 옮길지 정한 경우
        if (cnt == personList.size() - 1) {
            // B에 사람들 넣기
            selectedB.clear();
            for (int i = 1; i < personList.size() + 1; i++) {
                if (!visited[i]) {
                    for (int k = 0; k < distanceB.size(); k++) {
                        if (i == distanceB.get(k).number) {
                            selectedB.add(distanceB.get(k));
                        }
                    }
                }
            }
            Collections.sort(selectedB);
            // A time 구하기
            int timeA = 1;
            // B time 구하기
            int timeB = 1;
            // A time중 최소, B time중 최소 구해서 min Time과 비교하여 업데이트
            minTime = Math.min(minTime, Math.max(timeA, timeB));
            // System.out.println(minTime + " " + timeA + " " + timeB);
        }
        // 사람들 분리하기
        else {
            selectedA.add(distanceA.get(cnt));
            visited[distanceA.get(cnt).number] = true;
            // selectedA가 사라지기때문에 복사해둬야한다...
            ArrayList<Distance> selectedACopy = new ArrayList<>();
            for (int i = 0; i < selectedA.size(); i++) {
                selectedACopy.add(new Distance(selectedA.get(i).number, selectedA.get(i).distance));
            }
            find(cnt + 1);
            for (int i = 0; i < selectedACopy.size(); i++) {
                selectedA.add(new Distance(selectedACopy.get(i).number, selectedACopy.get(i).distance));
            }
            selectedA.remove(selectedA.size() - 1);
            visited[distanceA.get(cnt).number] = false;
            find(cnt + 1);
        }
    }
}

// 각 계단에 선택된 사람들의 정보 출력하기
// System.out.print("A = ");
// for (int i = 0; i < selectedA.size(); i++) {
// System.out.print(selectedA.get(i).number + ": " + selectedA.get(i).distance +
// " ");
// }
// System.out.print("\nB = ");
// for (int i = 0; i < selectedB.size(); i++) {
// System.out.print(selectedB.get(i).number + ": " + selectedB.get(i).distance +
// " ");
// }
// System.out.println();
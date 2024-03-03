import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static class Person {
        int x, y;
        int number;

        public Person(int number, int x, int y) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    static class Distance implements Comparable<Distance> {
        int number;
        int distance;

        public Distance(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance o) {
            return this.distance - o.distance;
        }
    }

    static class Stair {
        int wait;
        int move;

        public Stair() {
            this.wait = 0;
            this.move = 0;
        }
    }

    static int N;
    static int map[][];
    static ArrayList<int[]> stairSpot; // 계단위치
    static ArrayList<Person> persons; // 사람들의 번호와 위치
    static ArrayList<Distance> distancesA;
    static ArrayList<Distance> distancesB;
    static ArrayList<Distance> selectedA;
    static ArrayList<Distance> selectedB;
    static boolean visited[]; // 선택된 사람들의 정보를 담아둔다. - 인덱스번호가 사람의 번호
    static int minTime;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // 필요한 전역변수 및 지역변수 초기화
            map = new int[N][N];
            stairSpot = new ArrayList<>();
            persons = new ArrayList<>();
            int personNum = 0;

            // 사람들의 위치 정보 받기 + 계단 위치 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[i][k] = Integer.parseInt(st.nextToken());
                    if (map[i][k] == 1)
                        persons.add(new Person(++personNum, i, k)); // 고유번호와 현재 사람의 위치
                    else if (map[i][k] != 0)
                        stairSpot.add(new int[] { i, k, map[i][k] }); // 계단 위치와 계단의 크기
                }
            }

            calDistance(personNum);
            selectedA = new ArrayList<>();
            selectedB = new ArrayList<>();
            // System.out.println(personNum);
            visited = new boolean[personNum + 1];
            minTime = Integer.MAX_VALUE;
            calTime(0);

            sb.append("#" + t + " " + minTime + "\n");
        }
        System.out.println(sb);
    }

    public static void calTime(int cnt) {
        // 사람들 전부 분리한 경우
        if (cnt == persons.size()) {
            // B계단에 올라갈 사람들 저장
            selectedB.clear();
            for (int i = 1; i < persons.size() + 1; i++) {
                if (!visited[distancesB.get(i - 1).number]) {
                    selectedB.add(new Distance(distancesB.get(i - 1).number, distancesB.get(i - 1).distance));
                }
            }
            ArrayList<Distance> copySelectedA = new ArrayList<>();
            for (int i = 0; i < selectedA.size(); i++) {
                copySelectedA.add(new Distance(selectedA.get(i).number, selectedA.get(i).distance));
            }
            // System.out.print("A = ");
            // for (int i = 0; i < selectedA.size(); i++) {
            // System.out.print(selectedA.get(i).number + ":" + selectedA.get(i).distance +
            // " ");
            // }
            // System.out.print("\nB = ");
            // for (int i = 0; i < selectedB.size(); i++) {
            // System.out.print(selectedB.get(i).number + ":" + selectedB.get(i).distance +
            // " ");
            // }
            // System.out.println();

            // 시간계산하기
            int timeA = 0;
            ArrayList<Stair> stairsA = new ArrayList<>();
            while (!selectedA.isEmpty()) {

                // 아래층에 도착한 인원 보기
                for (int i = 0; i < stairsA.size(); i++) {
                    if (i >= 3)
                        break;
                    else {
                        if (stairsA.get(i).move == stairSpot.get(0)[2]) {
                            stairsA.remove(i);
                            selectedA.remove(0);
                            i--;
                            continue;
                        }
                    }
                }
                // 내려갈 수 있는 인원은 3
                for (int i = 0; i < stairsA.size(); i++) {
                    if (i >= 3)
                        break;
                    else {
                        stairsA.get(i).move++;
                    }
                }
                // 계단에 도착한 사람들의 정보 저장
                for (int i = 0; i < selectedA.size(); i++) {
                    if (selectedA.get(i).distance == timeA) {
                        stairsA.add(new Stair());
                        stairsA.get(stairsA.size() - 1).wait++;
                    }
                }
                if (selectedA.isEmpty())
                    break;
                timeA++;

            }

            int timeB = 0;
            ArrayList<Stair> stairsB = new ArrayList<>();
            while (!selectedB.isEmpty()) {

                // 아래층에 도착한 인원 보기
                for (int i = 0; i < stairsB.size(); i++) {
                    if (i >= 3)
                        break;
                    else {
                        if (stairsB.get(i).move == stairSpot.get(1)[2]) {
                            stairsB.remove(i);
                            selectedB.remove(0);
                            i--;
                            continue;
                        }
                    }
                }
                // 내려갈 수 있는 인원은 3
                for (int i = 0; i < stairsB.size(); i++) {
                    if (i >= 3)
                        break;
                    else {
                        stairsB.get(i).move++;
                    }
                }
                // 계단에 도착한 사람들의 정보 저장
                for (int i = 0; i < selectedB.size(); i++) {
                    if (selectedB.get(i).distance == timeB) {
                        stairsB.add(new Stair());
                        stairsB.get(stairsB.size() - 1).wait++;
                    }
                }
                if (selectedB.isEmpty())
                    break;
                timeB++;

            }
            // System.out.println(timeA + " " + timeB);
            minTime = Math.min(minTime, Math.max(timeA, timeB));
            for (int i = 0; i < copySelectedA.size(); i++) {
                selectedA.add(new Distance(copySelectedA.get(i).number, copySelectedA.get(i).distance));
            }

        }
        // A 계단에 어떤 사람이 갈 지 정하기
        else {
            // distancesA 앞에서부터 하나씩 추가하기
            selectedA.add(new Distance(distancesA.get(cnt).number, distancesA.get(cnt).distance));
            visited[distancesA.get(cnt).number] = true;
            calTime(cnt + 1);

            selectedA.remove(selectedA.size() - 1);
            // 추가없이 돌리기
            visited[distancesA.get(cnt).number] = false;

            calTime(cnt + 1);
        }
    }

    public static void calDistance(int personNum) {
        distancesA = new ArrayList<>();
        distancesB = new ArrayList<>();
        // 각 사람의 위치에서 계단까지 거리 계산
        for (int i = 0; i < personNum; i++) {
            distancesA.add(new Distance(persons.get(i).number, Math.abs(persons.get(i).x - stairSpot.get(0)[0])
                    + Math.abs(persons.get(i).y - stairSpot.get(0)[1])));
            distancesB.add(new Distance(persons.get(i).number, Math.abs(persons.get(i).x - stairSpot.get(1)[0])
                    + Math.abs(persons.get(i).y - stairSpot.get(1)[1])));
        }
        Collections.sort(distancesA);
        Collections.sort(distancesB);
    }
}

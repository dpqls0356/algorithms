import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int row = 0;
        int col = 0;
        char arr[][] = new char[N][M];
        for (int a = 0; a < T; a++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                if (str.contains("<")) {
                    row = i;
                    col = str.indexOf("<");
                }
                if (str.contains(">")) {
                    row = i;
                    col = str.indexOf(">");
                }
                if (str.contains("^")) {
                    row = i;
                    col = str.indexOf("^");
                }
                if (str.contains("v")) {
                    row = i;
                    col = str.indexOf("v");
                }
                arr[i] = str.toCharArray();
            }
            st = new StringTokenizer(br.readLine());
            int round = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String move = st.nextToken();

            for (int i = 0; i < round; i++) {
                if (move.charAt(i) == 'U') {
                    if (row - 1 >= 0 || arr[row - 1][col] == '.') {
                        arr[row][col] = '.';
                        arr[row - 1][col] = '^';
                    } else {
                        arr[row][col] = '^';
                    }
                    // 이동이 가능한지 => 가능하면 현재 위치를 평지로 바꾸고 한칸앞으로가기
                    // 불가능하면 화살표만 바꾸기
                } else if (move.charAt(i) == 'D') {
                    if (row + 1 < N || arr[row + 1][col] == '.') {
                        arr[row][col] = '.';
                        arr[row + 1][col] = 'v';
                    } else {
                        arr[row][col] = 'v';
                    }

                } else if (move.charAt(i) == 'L') {
                    if (col - 1 >= 0 || arr[row][col - 1] == '.') {
                        arr[row][col] = '.';
                        arr[row][col - 1] = '<';
                    } else {
                        arr[row][col] = '<';
                    }

                } else if (move.charAt(i) == 'R' || arr[row][col + 1] == '.') {
                    if (col + 1 < M) {
                        arr[row][col] = '.';
                        arr[row][col + 1] = '>';
                    } else {
                        arr[row][col] = '>';
                    }

                } else if (move.charAt(i) == 'S') {
                    if (arr[row][col] == '^') {
                        for (int k = row; k >= 0; k--) {
                            if (arr[k][col] == '*') {
                                arr[k][col] = '.';
                                break;
                            }
                            if (arr[k][col] == '#') {
                                break;
                            }
                        }
                    }
                    if (arr[row][col] == 'v') {
                        for (int k = row; k < N; k++) {
                            if (arr[k][col] == '*') {
                                arr[k][col] = '.';
                                break;
                            }
                            if (arr[k][col] == '#') {
                                break;
                            }
                        }
                    }
                    if (arr[row][col] == '<') {
                        for (int k = col; k >= 0; k--) {
                            if (arr[row][k] == '*') {
                                arr[row][k] = '.';
                                break;
                            }
                            if (arr[row][k] == '#') {
                                break;
                            }
                        }
                    }
                    if (arr[row][col] == '>') {
                        for (int k = col; k < M; k++) {
                            if (arr[row][k] == '*') {
                                arr[row][k] = '.';
                                break;
                            }
                            if (arr[row][k] == '#') {
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + (a + 1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.println(arr[i][j]);
                }
                System.out.println();
            }
        }

    }
}

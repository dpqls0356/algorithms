import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        String operators = "+-/*";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int res = 1;
            int n = Integer.parseInt(br.readLine());
            int leaf = n / 2 + 1; // 첫 단말노드
            for (int i = 0; i < n; i++) {
                String[] input = (br.readLine()).split(" ");
                int root = Integer.parseInt(input[0]);
                String operator = input[1];

                // 단말노드인 경우엔 연산자를 갖을 수 없다는 성질 사용
                if (root >= leaf) {
                    if (operators.contains(operator)) {
                        res = 0;
                        continue;
                    }
                }
            }
            System.out.printf("#%d %d", t + 1, res);
            System.out.println();
        }
    }
}
